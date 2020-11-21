package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.bo.AuthenticationRequest;
import com.user.bo.AuthenticationResponse;
import com.user.bo.User;
import com.user.service.MyUserDetailsService;
import com.user.service.UserService;
import com.user.util.JwtUtil;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
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
	
	@DeleteMapping("/delete/{id}")
	public void deleteUserById(@PathVariable int id){
		userService.deleteUser(id);
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable int id){
		return userService.getUserById(id);
	}
	
	@GetMapping("/name/{username}")
	public User getUserByName(@PathVariable String username) {
		return userService.getUserByName(username);
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest request) throws Exception{

		try {
			authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		} catch (Exception e) {
			 e.printStackTrace();
		}
		final UserDetails userDetails =  userDetailService.loadUserByUsername(request.getUsername());
		if(request.getUsername().equalsIgnoreCase(userDetails.getUsername()) && request.getPassword().equalsIgnoreCase(userDetails.getPassword())) {
		final String jwtToken = jwtTokenUtil.generateToken(userDetails);
			return ResponseEntity.ok(new AuthenticationResponse(jwtToken));
		}else {
			return ResponseEntity.ok("Entered wrong password");
		}
	}
	
	@GetMapping("/validate")
	public boolean isUserValidated(String jwtToken) {
		
		
		return true;
	}
}