package com.hari.hibernate.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hari.hibernate.exception.DBException;
import com.hari.hibernate.exception.UserNotFoundException;
import com.hari.hibernate.model.UserDetails;
import com.hari.hibernate.repository.UserDetailsHibernateRepo;
@Service
public class UserServiceImpl implements  UserService{

	@Autowired
	private UserDetailsHibernateRepo repo;
		
	@Override
	public List<UserDetails> findAllUsers() throws UserNotFoundException {
		//List<UserDetails> users=new ArrayList<>();
		Optional<List<UserDetails>> userDetails=repo.fetchUserDetails();
		if(!userDetails.isPresent()) {
			
			throw new UserNotFoundException("userDetails not Found");
		}
		return userDetails.get();
	}

	@Override
	@Transactional
	public UserDetails addUserDetails(UserDetails userDetails) throws DBException {
		
		UserDetails user=repo.addUserDetails(userDetails);
		if(!Objects.nonNull(user)) {
			throw new DBException("UserDetails Not saved");
		}
		return user;
	}

}
