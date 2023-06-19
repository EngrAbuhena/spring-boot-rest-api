package com.rony.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rony.restapi.model.Employee;
import com.rony.restapi.service.EmployeeService;

@RestController
@RequestMapping(value = "/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// READ
	@GetMapping(value = "/employees", produces = "application/json")
	public ResponseEntity<List<Employee>> readEmployees() {
		return ResponseEntity.ok().body(this.employeeService.getAllEmployees());
	}

	// READ
	@GetMapping(value = "/employee/{id}", produces = "application/json")
	public ResponseEntity<Employee> readEmployees(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<Employee>(this.employeeService.getEmployeeById(id), HttpStatus.OK);
	}

	// CREATE
	@PostMapping(value = "/employees", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Employee> createEmployee(@Validated @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(this.employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}

	// UPDATE
	@PutMapping(value = "/employee/{id}")
	public ResponseEntity<Employee> readEmployees(@PathVariable(value = "id") Long id,
			@RequestBody Employee employeeDetails) {
		return ResponseEntity.ok().body(this.employeeService.updateEmployee(id, employeeDetails));
	}

	// DELETE
	@DeleteMapping(value = "/employee/{id}")
	public HttpStatus deleteEmployee(@PathVariable(value = "id") Long id) {
		this.employeeService.deleteEmployee(id);
		return HttpStatus.OK;
	}
}
