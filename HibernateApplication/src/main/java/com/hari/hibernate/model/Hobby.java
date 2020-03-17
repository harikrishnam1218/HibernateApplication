package com.hari.hibernate.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="hobby")
public class Hobby {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long hid;
	
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY,mappedBy = "hobbies")
	private Set<UserDetails> users;

	public Long getHid() {
		return hid;
	}

	public void setHid(Long hid) {
		this.hid = hid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UserDetails> getUsers() {
		return users;
	}

	public void setUsers(Set<UserDetails> users) {
		this.users = users;
	}
	

}
