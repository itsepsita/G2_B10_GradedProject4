package com.EmployeeManagementRest.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
		
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id)
	{
		return employeeService.getEmployeeById(id);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable Lond id) {
		employeeService.deleteEmployee(id);
		return "Deleted employee id -" +id;
		
	}
	
	@GetMapping("/search/{firstName}")
	public List<Employee> getEmployeesByFristName(@PathVariable String firstName){
		return employeeService.getEmployeesByFirstName(firstName);
	}
	
	
	@GetMapping("/sort")
	public List<Employee>  getEmployeesSortedByFirstName(@RequestParam(defaultValue = "asc") String order){
		return employeeService.getEmployeesSortedByFirstName(order);
	}
}
