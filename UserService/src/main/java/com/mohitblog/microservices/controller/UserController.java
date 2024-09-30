package com.mohitblog.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohitblog.microservices.Entity.User;
import com.mohitblog.microservices.Services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	  @Autowired
	  private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> createUser(User user) {
		 User user1 = userService.saveUser(user);
	        return ResponseEntity.status(HttpStatus.CREATED).body(user1);

	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUseEntity(@PathVariable String userId) {
		  User user = userService.getSingleUser(userId);
	        return ResponseEntity.ok(user);
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		 List<User> allUser = userService.getAllUsers();
	        return ResponseEntity.ok(allUser);
	}
}
