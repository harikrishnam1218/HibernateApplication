package com.hari.hibernate.repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hari.hibernate.model.Address;
import com.hari.hibernate.model.UserDetails;

@Repository
public class UserDetailsHibernateRepo {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Optional<List<UserDetails>> fetchUserDetails(){
		//(sessionFactory.openSession().createQuery("from UserDetails").getResultList());
		Session session=sessionFactory.getCurrentSession();
		return 	Optional.of((List<UserDetails>)session.createQuery("from UserDetails").getResultList());
	}
	public UserDetails addUserDetails(UserDetails details){
		
		  Set<Address> list=details.getAddress();
		  for (Address address : list) {
		  address.setUserDetails(details);
		  } 
		  details.setAddress(list);
		  sessionFactory.getCurrentSession().save(details);
		/*
		 * Session sess= sessionFactory.openSession(); sess.persist(details);
		 * sess.close();
		 */
		
		return Objects.nonNull(details) && Objects.nonNull(details.getUid())?details:null;
	}
}
