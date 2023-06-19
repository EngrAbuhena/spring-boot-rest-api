package com.rony.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rony.restapi.model.Employee;
import com.rony.restapi.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	// READ
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException("Employee not found for the id:: " + id);
		}
		return employee;
	}

	// CREATE
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	// UPDATE
	@Override
	public Employee updateEmployee(long id, Employee employeeDetails) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
			employee.setEmployeeName(employeeDetails.getEmployeeName());
			employee.setEmployeeEmail(employeeDetails.getEmployeeEmail());
			employee.setEmployeePost(employeeDetails.getEmployeePost());
			employee.setEmployeeSalary(employeeDetails.getEmployeeSalary());

			return employeeRepository.save(employee);
		} else {
			throw new RuntimeException("Employee not found for the id:: " + id);
		}

	}

	// DELETE
	@Override
	public String deleteEmployee(long id) {
		employeeRepository.deleteById(id);
		return "Employee info deleted for the id:: " + id;
	}

}
