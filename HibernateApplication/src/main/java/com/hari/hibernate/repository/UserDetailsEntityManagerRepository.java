package com.hari.hibernate.repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hari.hibernate.model.UserDetails;

//@Repository
public class UserDetailsEntityManagerRepository {
	/*
	 * @Autowired
	 * 
	 * @PersistenceUnit private EntityManager entityManager;
	 * 
	 * public Optional<List<UserDetails>> fetchUserDetails(){ Session
	 * session=entityManager.unwrap(Session.class);
	 * //(sessionFactory.openSession().createQuery("from UserDetails").getResultList
	 * ()); return
	 * Optional.of((List<UserDetails>)session.createQuery("from UserDetails").
	 * getResultList()); } public Integer addUserDetails(UserDetails details){
	 * entityManager.persist(details); Integer value=Objects.nonNull(details) &&
	 * Objects.nonNull(details.getUid())?1:null; return value; }
	 */
}
