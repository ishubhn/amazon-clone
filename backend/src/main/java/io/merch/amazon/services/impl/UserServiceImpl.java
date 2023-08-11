package io.merch.amazon.services.impl;

import io.merch.amazon.exception.InvalidAgeException;
import io.merch.amazon.exception.NoSuchUserExistException;
import io.merch.amazon.models.UsersEntity;
import io.merch.amazon.models.dto.request.UserDeleteRequest;
import io.merch.amazon.models.dto.request.UserRequest;
import io.merch.amazon.models.dto.response.MessageResponse;
import io.merch.amazon.models.dto.response.UserResponse;
import io.merch.amazon.repo.UserRepository;
import io.merch.amazon.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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
	private UserRepository userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserResponse getUserByEmailId(String emailId) {
		 Optional<UsersEntity> user = userRepo.findByEmailId(emailId);

		 if (user.isPresent()) {
			 return modelMapper.map(user, UserResponse.class);
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
		return userRepo.findAll()
				.stream()
				.map(this::convertToResponse)
				.collect(Collectors.toList());
	}

	@Override
	public List<UserResponse> getUsersByFirstNameOrLastName(String name) {
		return null;
	}

	@Override
	public MessageResponse deleteUser(UserDeleteRequest request) {
		return null;
	}

	private UserResponse convertToResponse(UsersEntity entity) {
		UserResponse response = modelMapper.map(entity, UserResponse.class);

		return new UserResponse(response.getId(),
				response.getFirstName(), response.getLastName(), response.getContactNumber(),
				response.getAlternateContactNumber(), response.getEmailId(), response.getAge(),
				response.getAddressResponse());
	}

	private boolean isUserExist(String emailId, String contactNumber) {
		if (emailId != null) {
			Optional<UsersEntity> userByEmail = userRepo.findByEmailId(emailId);

			if (userByEmail.isPresent()) {
				return true;
			}
		}

		if (contactNumber != null) {
			Optional<UsersEntity> userByContact = userRepo.findByContactNumber(contactNumber);

			if (userByContact.isPresent()) {
				return true;
			}
		}

		return false;
	}

	public static int calculateAge(LocalDate birthDate) {
		LocalDate currentDate = LocalDate.now();

		if ((birthDate != null)) {
			return Period.between(birthDate, currentDate).getYears();
		} else {
			throw new InvalidAgeException("An error occurred while calculating age for the user.");
		}
	}

	@Override
	public MessageResponse createUser(UserRequest request) {
		boolean flag = isUserExist(request.getEmailId(), request.getContactNumber());
		log.info("Does user {} exist already? -> {}", request.getEmailId(), flag);

		// If user is not already present, then create new user
		if (!flag) {
			if (request.getPassword().equals(request.getConfirmPassword())) {
				UsersEntity usersEntity = modelMapper.map(request, UsersEntity.class);
				usersEntity.setAge(calculateAge(request.getDateOfBirth()));
				userRepo.save(usersEntity);

				log.info("User is created successfully! User email id -> {}", request.getEmailId());
				return new MessageResponse("SUCCESS",
						String.format("User is created successfully! User email id -> %s", request.getEmailId()));
			} else {
				log.info("Password and confirm password doesn't match for users");
				return new MessageResponse("ERROR", "Password and confirm password doesn't match for users"
				);
			}
		} else {
			return new MessageResponse("ERROR",
					String.format("User is not created! User already exist -> %s", request.getEmailId()));
		}
	}
}
