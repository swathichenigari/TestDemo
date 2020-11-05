package com.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.bo.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/allusers")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@PostMapping("/saveUser")
	public void saveUser(@RequestBody User user){
		 userService.saveUser(user);
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user){
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUserById(@PathVariable int id){
		userService.deleteUser(id);
	}
	
	@GetMapping("/getUser/{id}")
	public Optional<User> getUser(@PathVariable int id){
		return userService.getUserById(id);
	}
	
}
