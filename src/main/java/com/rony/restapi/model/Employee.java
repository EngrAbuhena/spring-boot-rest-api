package com.rony.restapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empid")
	private long employeeId;

	@Column(name = "empname", length = 30, nullable = false)
	private String employeeName;

	@Column(name = "empemail", length = 45, nullable = false, unique = true)
	private String employeeEmail;

	@Column(name = "emppost", length = 15)
	private String employeePost;

	@Column(name = "empsalary", length = 4)
	private double employeeSalary;

	// getters and setters
	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeePost() {
		return employeePost;
	}

	public void setEmployeePost(String employeePost) {
		this.employeePost = employeePost;
	}

	public double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
}
