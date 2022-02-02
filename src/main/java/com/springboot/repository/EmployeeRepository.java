package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	
	@Query("SELECT *from emp where first_name LIKE %?1% ")
	List<Employee> searchEmployee(String searchQuery);
	
}
