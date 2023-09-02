package io.merch.amazon.services.impl;

import io.merch.amazon.exception.InvalidAgeException;
import io.merch.amazon.exception.InvalidCredentialsException;
import io.merch.amazon.exception.NoSuchUserExistException;
import io.merch.amazon.models.UsersEntity;
import io.merch.amazon.models.dto.Status;
import io.merch.amazon.models.dto.mapper.UserMapper;
import io.merch.amazon.models.dto.requests.LoginUserRequest;
import io.merch.amazon.models.dto.requests.UserRequest;
import io.merch.amazon.models.dto.response.MessageResponse;
import io.merch.amazon.models.dto.response.UserResponse;
import io.merch.amazon.repo.UsersRepository;
import io.merch.amazon.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRepository usersRepo;

	public static int calculateAge(LocalDate birthDate) {
		LocalDate currentDate = LocalDate.now();

		if ((birthDate != null)) {
			return Period.between(birthDate, currentDate).getYears();
		} else {
			throw new InvalidAgeException("An error occurred while calculating age for the user.");
		}
	}

	/*
	 * @Author - Shubham Nagre
	 * @Param - emailId
	 * Fetch user from db using email id
	 * */
	@Override
	public UserResponse getUserByEmailId(String emailId) {
		Optional<UsersEntity> user = usersRepo.findByEmailId(emailId);

		if (user.isPresent()) {
			return UserMapper.toUsersResponse(user.get());
		} else {
			throw new NoSuchUserExistException(String.format("No such user present with email id -> %s", emailId));
		}
	}

	@Override
	public UserResponse getUserByContactNumber(String contactNumber) {
		return null;
	}

	@Override
	public List<UserResponse> getAllUsers() {
		return usersRepo.findAll()
				.stream()
				.map(UserMapper::toUsersResponse)
				.collect(Collectors.toList());
	}

	@Override
	public List<UserResponse> getUsersByFirstNameOrLastName(String name) {
		return usersRepo.findByFirstNameOrLastName(name)
				.stream()
				.map(UserMapper::toUsersResponse)
				.collect(Collectors.toList());
	}

	@Override
	public MessageResponse createUser(UserRequest request) {
		boolean flag = isUserExist(request.getEmailId(), request.getContactNumber());
		log.info("Does user {} exist already? -> {}", request.getEmailId(), flag);

		// If user is not already present, then create new user
		if (!flag) {
			if (request.getPassword().equals(request.getConfirmPassword())) {
				UsersEntity usersEntity = UserMapper.toUsersEntity(request);
				usersEntity.setAge(calculateAge(request.getDateOfBirth()));
				usersRepo.save(usersEntity);

				log.info("User is created successfully! User email id -> {}", request.getEmailId());
				return new MessageResponse(Status.SUCCESS,
						String.format("User is created successfully! User email id -> %s", request.getEmailId()),
						null);
			} else {
				log.info("Password and confirm password doesn't match for users");
				return new MessageResponse(Status.FAILURE, "Password and confirm password doesn't match" +
						" for users", null
				);
			}
		} else {
			return new MessageResponse(Status.FAILURE,
					String.format("User is not created! User already exist -> %s", request.getEmailId()), null);
		}
	}

	@Override
//	@Transactional
	public Boolean deleteUser(String identifier) {
		Optional<UsersEntity> user;

		if (identifier.contains("@")) {
			user = usersRepo.findByEmailId(identifier);
		} else {
			user = usersRepo.findByContactNumber(identifier);
		}

		if (user.isPresent()) {
			usersRepo.deleteById(user.get().getId());
			log.info("user is deleted successfully! (identifier -> {})", identifier);
			return true;
		} else {
			throw new NoSuchUserExistException(String.format("No such user exist in the system with identifier -> %s", identifier));
		}
	}

	@Override
	public Boolean loginUser(LoginUserRequest loginUser) {
		Optional<UsersEntity> user;

		if (loginUser.getIdentifier().contains("@")) {
			user = usersRepo.findByEmailId(loginUser.getIdentifier());
		} else {
			user = usersRepo.findByContactNumber(loginUser.getIdentifier());
		}

		if (user.isPresent()) {
			if (user.get().getPassword().equals(loginUser.getPassword())) {
				log.info("User is logged in successfully");
				return true;
			} else {
				log.error("Either credentials or username is incorrect.");
				throw new InvalidCredentialsException("Either credentials or username is incorrect");
			}
		} else {
			throw new NoSuchUserExistException(String.format("No such user exist with identifier -> %s",
					loginUser.getIdentifier()));
		}
	}

	private boolean isUserExist(String identifier) {
		if (identifier.contains("@")) {
			Optional<UsersEntity> userByEmail = usersRepo.findByEmailId(identifier);

			if (userByEmail.isPresent()) {
				return true;
			}
		} else if (!identifier.isEmpty()) {
			Optional<UsersEntity> userByContact = usersRepo.findByContactNumber(identifier);

			return userByContact.isPresent();
		}

		return false;
	}

	private boolean isUserExist(String emailId, String contactNumber) {
		if (emailId != null) {
			Optional<UsersEntity> userByEmail = usersRepo.findByEmailId(emailId);

			if (userByEmail.isPresent()) {
				return true;
			}
		}

		if (contactNumber != null) {
			Optional<UsersEntity> userByContact = usersRepo.findByContactNumber(contactNumber);

			return userByContact.isPresent();
		}

		return false;
	}
}
