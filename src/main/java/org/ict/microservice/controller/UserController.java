package org.ict.microservice.controller;

import java.util.List;

import org.ict.microservice.entity.User;
import org.ict.microservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return service.saveUser(user);
	}

	@PostMapping("/addUsers")
	public List<User> addUsers(@RequestBody List<User> users) {
		return service.saveUsers(users);
	}

	@GetMapping("/users")
	public List<User> findAllUsers() {
		return service.getUsers();
	}

	@GetMapping("/userById/{id}")
	public User findUserById(@PathVariable int id) {
		return service.getUserById(id);
	}

	@GetMapping("/userByUserName/{userName}")
	public User findUserByUserName(@PathVariable String userName) {
		return service.getUserByUserName(userName);
	}

	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}

	@DeleteMapping("/deleteById/{id}")
	public String deleteUser(@PathVariable int id) {
		return service.deleteUserById(id);
	}
	@DeleteMapping("/deleteByUserName/{userName}")
	public String deleteUserByUserName(@PathVariable String userName) {
		return service.deleteUserByName(userName);
	}
}
