package com.EmployeeManagementRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeManagementRest.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByName(String name);

}
