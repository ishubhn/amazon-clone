package io.merch.amazon.controllers;

import io.merch.amazon.models.dto.request.UserRequest;
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
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UserServiceImpl userService;

	@GetMapping("/search/all")
	public ResponseEntity<List<UserResponse>> getAllUsers() {
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.FOUND);
	}

	@PostMapping("/new")
	public ResponseEntity<MessageResponse> createNewUser(@RequestBody UserRequest request) {
		return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
	}
}
