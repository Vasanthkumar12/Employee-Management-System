package com.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.Employee;
import com.springboot.exception.ResourceNotFoundException;
import com.springboot.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository empRepository;

	public EmployeeServiceImpl(EmployeeRepository empRepository) {
		super();
		this.empRepository = empRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return empRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return empRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employee=empRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		else {
			throw new ResourceNotFoundException("Employee","fieldName","fieldValue");
		}
		//return empRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","id",id));
	}

	@Override
	public void deleteEmployee(long id) {
		empRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","id","id"));
		empRepository.deleteById(id);
		
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		//first we need to check whether employee with given id is existing or no
		
		Employee existingEmployee = empRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Employee Updation","Error","ID not Found"));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
	//save existing employee to DataBase
		empRepository.save(existingEmployee);
		return existingEmployee;
	}
    
	public List<Employee> searchQuery(String query){
		return empRepository.searchEmployee(query);
	}
}
