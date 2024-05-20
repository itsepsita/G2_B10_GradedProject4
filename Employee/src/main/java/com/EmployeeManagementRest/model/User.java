package com.EmployeeManagementRest.model;


import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String username;
	
	@Column(unique = true)
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> roles = new HashSet<>();

	public String getusername() {
		return username;
	}
	

}
