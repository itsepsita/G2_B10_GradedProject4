package com.EmployeeManagementRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	List<Employee> findByFirstName(String firstName);

}
