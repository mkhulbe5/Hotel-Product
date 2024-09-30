package com.mohitblog.microservices.Services;

import java.util.List;

import com.mohitblog.microservices.Entity.User;

public interface UserService {

	User saveUser(User user);
	List<User> getAllUsers();
	User getSingleUser(String userId);
	void deleteUser(String userId);
	
	
}
