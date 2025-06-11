package com.example.backend_fil_rouge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_fil_rouge.models.User;
import com.example.backend_fil_rouge.services.UserService;

@RestController
@RequestMapping(path = "api/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping(path = "", produces = "application/json")
	public ResponseEntity<List<User>> getUsers(){
		try {
			List<User> users = userService.getUsers();
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<User> getUserById(@PathVariable Long id) 
	{
		try {
			User user = userService.getUserById(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path = "", produces = "application/json")
	public ResponseEntity<User> addUser(@RequestBody User user)
	{
		try {
			User _user = userService.addUser(user);
			return new ResponseEntity<User>(_user, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id)
	{
		try {
			User _user = userService.UpdateUser(user, id);
			return new ResponseEntity<User>(_user, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(path = "", produces = "application/json")
	public ResponseEntity<HttpStatus> deleteUsers() {
		try {
			userService.deleteCategories();
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<HttpStatus> deleteUserById(@PathVariable Long id)
	{
		try {
			userService.deleteUserById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
