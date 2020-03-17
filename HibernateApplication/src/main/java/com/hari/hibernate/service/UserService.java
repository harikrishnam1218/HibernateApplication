package com.hari.hibernate.service;

import java.util.List;

import com.hari.hibernate.exception.DBException;
import com.hari.hibernate.exception.UserNotFoundException;
import com.hari.hibernate.model.UserDetails;

public interface UserService {
	
 public List<UserDetails> findAllUsers() throws UserNotFoundException;
 public UserDetails addUserDetails(UserDetails userDetails) throws DBException;
 
}
