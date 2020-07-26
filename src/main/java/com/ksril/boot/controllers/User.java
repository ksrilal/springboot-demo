package com.ksril.boot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ksril.boot.domain.UserDTO;
import com.ksril.boot.services.UserServices;

@RestController
@RequestMapping("/user")
public class User {

	@Autowired
	private UserServices userServices;
	
	@GetMapping("/all")
	public List<UserDTO> allUsers() {
		return userServices.findAllUsers();
	}
	
	@PostMapping("/add")
	public String addUser(@RequestBody UserDTO userData) {
		return userServices.saveUser(userData);
	}
	
	@PutMapping("/update")
	public String updateUser(@RequestBody UserDTO newUserData) {
		return userServices.updateUser(newUserData);
	}
	
	@GetMapping("/find/{id}")
	public UserDTO getUserById(@PathVariable Integer id) {
		return userServices.findById(id);
	}
}
