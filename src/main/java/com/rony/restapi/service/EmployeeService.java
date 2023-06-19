package com.rony.restapi.service;

import java.util.List;

import com.rony.restapi.model.Employee;

public interface EmployeeService {

	// READ
	List<Employee> getAllEmployees();

	Employee getEmployeeById(long id);

	// CREATE
	Employee saveEmployee(Employee employee);

	// UPDATE
	Employee updateEmployee(long id, Employee employeeDetails);

	// DELETE
	String deleteEmployee(long id);
}
