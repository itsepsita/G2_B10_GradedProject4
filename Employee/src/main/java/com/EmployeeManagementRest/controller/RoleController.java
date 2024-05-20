package com.EmployeeManagementRest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping
	public Role createRole(@RequestBody Role role) {
		return roleSErvice.createRole(role);
	}
	
	@GetMapping
	public List<Role> getAllRoles(){
		return roleService.getAllRole();
	}

}
