package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.bo.User;
import com.user.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public List<User> getUsers(){
		return userRepo.findAll();
	}
	
	public void saveUser(User user) {
		userRepo.save(user);
	}
	
	public User updateUser(User user) {
		return userRepo.save(user);
	}
	
	public User getUserById(int id) {
		return userRepo.findById(id).get();
	}
	
	public void deleteUser(int id) {
		userRepo.deleteById(id);
	}
	
	public User getUserByName(String username) {
		return getUsers().stream().filter(name-> name.getUsername().equalsIgnoreCase(username)).findFirst().get();
	}
	
}
