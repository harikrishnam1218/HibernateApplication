package com.hari.hibernate.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hari.hibernate.exception.DBException;
import com.hari.hibernate.model.UserDetails;
import com.hari.hibernate.service.UserService;
import com.hari.hibernate.service.UserServiceImpl;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/userList")
	public ResponseEntity<List<UserDetails>> fetchUSerdetails() {
		List<UserDetails> userDetails=userService.findAllUsers();
		return new ResponseEntity(userDetails,HttpStatus.OK);
	}
	@PostMapping(value="/addUser")
	public ResponseEntity<UserDetails> addUserDetails(@Valid @RequestBody UserDetails userDetails) throws DBException {
		UserDetails user=userService.addUserDetails(userDetails);
		return new ResponseEntity(user,HttpStatus.OK);
	}
	
	
}
