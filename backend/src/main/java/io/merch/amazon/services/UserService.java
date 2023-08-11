package io.merch.amazon.services;

import io.merch.amazon.models.dto.request.UserDeleteRequest;
import io.merch.amazon.models.dto.request.UserRequest;
import io.merch.amazon.models.dto.response.MessageResponse;
import io.merch.amazon.models.dto.response.UserResponse;

import java.util.List;

public interface UserService {
	UserResponse getUserByEmailId(String emailId);

	UserResponse getUserByContactNumber(String contactNumber);

	List<UserResponse> getAllUsers();

	List<UserResponse> getUsersByFirstNameOrLastName(String name);

	MessageResponse createUser(UserRequest request);

	boolean deleteUser(String identifier);
}
