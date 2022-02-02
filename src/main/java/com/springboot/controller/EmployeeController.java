 package com.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Employee;
import com.springboot.service.impl.EmployeeService;
import java.lang.String;
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService empService;

	public EmployeeController(EmployeeService empService) {
		super();
		this.empService = empService;
	}
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
    	return new ResponseEntity<Employee>(empService.saveEmployee(employee),HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(name = "username") String username){
    	System.out.println(username);
    	if(username.equals("vasanth"))
    		return new ResponseEntity<List<Employee>>(empService.getAllEmployees(), HttpStatus.OK);
    	else 
    		return new ResponseEntity<List<Employee>>(HttpStatus.FORBIDDEN);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(
    		@PathVariable("id")long empId){
    	return new ResponseEntity<Employee>(empService.getEmployeeById(empId),HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(
    		@PathVariable("id") long id,
    		@RequestBody Employee employee){
    	return new ResponseEntity<Employee>(empService.updateEmployee(employee,id),HttpStatus.OK);
    }

}
