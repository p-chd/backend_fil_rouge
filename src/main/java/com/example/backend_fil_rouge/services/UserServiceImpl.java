package com.example.backend_fil_rouge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend_fil_rouge.models.User;
import com.example.backend_fil_rouge.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElse(null);
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User UpdateUser(User user, Long id) {
		// TODO Replace all fields one by one, we cannot override this way
		Optional<User> tempUser = userRepository.findById(id);
		if (tempUser.isPresent())
		{
			User _user = tempUser.get();
			return userRepository.save(_user);
		}
		return null;
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public void deleteCategories() {
		userRepository.deleteAll();
	}
	
}
