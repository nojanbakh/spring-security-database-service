package org.ict.microservice.service;

import java.util.List;

import org.ict.microservice.entity.User;
import org.ict.microservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User saveUser(User user) {
		return repository.save(user);
	}

	public List<User> saveUsers(List<User> users) {
		return repository.saveAll(users);
	}
	
	public List<User> getUsers() {
		return repository.findAll();	
	}
	
	public User getUserById(int id) {
		return repository.findById(id).orElse(null);	
	}
	
	public User getUserByUserName(String userName) {
		return repository.findByUserName(userName).orElse(null);
	}
	
	public String deleteUserById(int id) {
		repository.deleteById(id);
		return "User removed !!" + id;	
	}
	public String deleteUserByName(String userName) {
		repository.deleteByUserName(userName).orElse(null);
		return "User removed !!" + userName;	
	}
	
	public User updateUser(User user) {
		User existingUser = repository.findById(user.getId()).orElse(null);
		existingUser.setUserName(user.getUserName());
		existingUser.setPassword(user.getPassword());
		existingUser.setActive(user.isActive());
		return repository.save(existingUser);
	}
}
