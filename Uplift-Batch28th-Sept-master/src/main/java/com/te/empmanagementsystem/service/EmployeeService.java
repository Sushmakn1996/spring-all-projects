package com.te.empmanagementsystem.service;

import java.util.List;

import com.te.empmanagementsystem.entity.Employee;

public interface EmployeeService {

	public boolean register(Employee employee);

	public Employee authenticate(Employee employee);
	
	public boolean deleteEmployee(String id);

	public boolean updateEmployee(Employee employee, Employee employee2);
	
	public List getAllDetails();

	
}
