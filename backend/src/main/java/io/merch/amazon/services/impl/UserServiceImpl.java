package io.merch.amazon.services.impl;

import io.merch.amazon.exception.InvalidAgeException;
import io.merch.amazon.exception.InvalidArgumentException;
import io.merch.amazon.exception.NoSuchUserExistException;
import io.merch.amazon.models.UsersEntity;
import io.merch.amazon.models.dto.Status;
import io.merch.amazon.models.dto.mapper.UserMapper;
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

	/*
	* @author - Shubham Nagre
	* @Param - emailId
	* Fetch user from db using email id
	* */
	@Override
	public UserResponse getUserByEmailId(String emailId) {
		 Optional<UsersEntity> user = userRepo.findByEmailId(emailId);

		 if (user.isPresent()) {
			 return UserMapper.toUsersResponse(user.get());
		 } else {
			 throw new NoSuchUserExistException(String.format("No such user present with email id -> %s", emailId));
		 }
	}

	/*
	 * @author - Shubham Nagre
	 * @Param - emailId
	 * Fetch user from db using contact number
	 * */
	@Override
	public UserResponse getUserByContactNumber(String contactNumber) {
		Optional<UsersEntity> user = userRepo.findByContactNumber(contactNumber);

		if (user.isPresent()) {
			return UserMapper.toUsersResponse(user.get());
		} else {
			throw new NoSuchUserExistException(String.format("No such user present with contact number -> %s",
					contactNumber));
		}
	}

	/*
	 * @author - Shubham Nagre
	 * @Param - emailId
	 * Fetch all users from db
	 * */
	@Override
	public List<UserResponse> getAllUsers() {
		return userRepo.findAll()
				.stream()
				.map(UserMapper::toUsersResponse)
				.collect(Collectors.toList());
	}

	@Override
	public List<UserResponse> getUsersByFirstNameOrLastName(String name) {
		return null;
	}

	@Override
	public MessageResponse deleteUser(UserDeleteRequest request) {
		if (isUserExist(request.getUserEmailId(), request.getContactNumber())) {
			if (request.getUserEmailId() == null && request.getContactNumber() != null) {
				Optional<UsersEntity> user = userRepo.findByContactNumber(request.getContactNumber());
				user.ifPresent(entity -> userRepo.delete(entity));

				return new MessageResponse(Status.SUCCESS, String.format("User is deleted successfully. Param -> %s",
						request.getContactNumber()));
			} else if (request.getUserEmailId() != null && request.getContactNumber() == null) {
				Optional<UsersEntity> user = userRepo.findByContactNumber(request.getUserEmailId());
				user.ifPresent(entity -> userRepo.delete(entity));

				return new MessageResponse(Status.SUCCESS, String.format("User is deleted successfully. Param -> %s",
						request.getUserEmailId()));
			} else {
				log.info("Invalid request! Either User Email Id or Contact Number should be present");
				throw new InvalidArgumentException("Invalid request! Either User Email Id " +
						"or Contact Number should be present");
			}
		} else {
			throw new NoSuchUserExistException(String.format("No such user exist with either contact number -> '%s' " +
					"and/or email id -> '%s'", request.getContactNumber(), request.getUserEmailId()));
		}
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

			return userByContact.isPresent();
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
				return new MessageResponse(Status.SUCCESS,
						String.format("User is created successfully! User email id -> %s", request.getEmailId()));
			} else {
				log.info("Password and confirm password doesn't match for users");
				return new MessageResponse(Status.FAILURE, "Password and confirm password doesn't match for users"
				);
			}
		} else {
			return new MessageResponse(Status.FAILURE,
					String.format("User is not created! User already exist -> %s", request.getEmailId()));
		}
	}
}
