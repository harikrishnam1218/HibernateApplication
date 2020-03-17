package com.hari.hibernate.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uid;
	
	private String name;
	
	private Integer age;
	
	private String role;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name="user_hobby",
			joinColumns = {@JoinColumn (name="uid")},
			inverseJoinColumns = {@JoinColumn( name="hid")})
	private Set<Hobby> hobbies;
	
	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL,mappedBy = "userDetails")
	//@JsonIgnoreProperties("userDetails")
	private Set<Address>  address;
	
	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public Set<Hobby> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Set<Hobby> hobbies) {
		this.hobbies = hobbies;
	}

	

}
