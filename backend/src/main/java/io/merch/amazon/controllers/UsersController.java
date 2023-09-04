package io.merch.amazon.controllers;

import io.merch.amazon.models.dto.Status;
import io.merch.amazon.models.dto.requests.LoginUserRequest;
import io.merch.amazon.models.dto.requests.UserRequest;
import io.merch.amazon.models.dto.response.MessageResponse;
import io.merch.amazon.models.dto.response.UserResponse;
import io.merch.amazon.services.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {
	@Autowired
	private UserServiceImpl userService;

	@GetMapping("/search/all")
	public ResponseEntity<List<UserResponse>> getAllUsers() {
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.FOUND);
	}

	@GetMapping("/search/email/{emailId}")
	public ResponseEntity<UserResponse> getUserByEmailId(@PathVariable String emailId) {
		return new ResponseEntity<>(userService.getUserByEmailId(emailId), HttpStatus.FOUND);
	}

	@GetMapping("/search/contact/{contactNumber}")
	public ResponseEntity<UserResponse> getUserByContactNumber(@PathVariable String contactNumber) {
		return new ResponseEntity<>(userService.getUserByContactNumber(contactNumber), HttpStatus.FOUND);
	}

	@GetMapping("/search/{name}")
	public ResponseEntity<List<UserResponse>> getUsersByFirstNameOrLastName(@PathVariable String name) {
		return new ResponseEntity<>(userService.getUsersByFirstNameOrLastName(name), HttpStatus.FOUND);
	}

	@PostMapping("/new")
	public ResponseEntity<MessageResponse> createNewUser(@RequestBody UserRequest request) {
		return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{identifier}")
	public ResponseEntity<MessageResponse> deleteUser(@PathVariable String identifier) {
		boolean isUserDeleted = userService.deleteUser(identifier);

		if (isUserDeleted) {
			return ResponseEntity.ok(new MessageResponse(Status.SUCCESS, "User deleted successfully",
					null));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/auth/login")
	public ResponseEntity<Boolean> loginUser(@RequestBody LoginUserRequest loginUser) {
		log.info(loginUser.toString());
		return new ResponseEntity<>(userService.loginUser(loginUser), HttpStatus.OK);
	}
}
