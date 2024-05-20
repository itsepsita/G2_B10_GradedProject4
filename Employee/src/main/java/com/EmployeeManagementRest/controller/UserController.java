package com.EmployeeManagementRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeManagementRest.model.User;
import com.EmployeeManagementRest.repository.UserRepository;


@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping
	public ResponseEntity createUser(@RequestBody User user) {
		User exsistingUser = userRepository.findByUsername(user.getusername());
		if(exsistingUser!=null) {
			return new ResponseEntity<>("Username already exists",HttpStatus.BAD_REQUEST);
			
		}
		userRepository.save(user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = userRepository.findAll();
		
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

}
