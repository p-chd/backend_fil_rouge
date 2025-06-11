package com.example.backend_fil_rouge.services;

import java.util.List;

import com.example.backend_fil_rouge.models.User;

public interface UserService {

	List<User> getUsers();
	
	User getUserById(Long id);
	
	User addUser(User user);
	
	User UpdateUser(User user, Long id);
	
	void deleteUserById(Long id);
	
	void deleteCategories();
	
}
