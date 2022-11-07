package com.te.springbootemployee.service;

import java.util.List;

import com.te.springbootemployee.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployee();

	public Employee register(Employee employee);

	public Employee login(Employee employee);

}
