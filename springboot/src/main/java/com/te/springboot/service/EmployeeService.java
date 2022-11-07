package com.te.springboot.service;

import com.te.springboot.entity.Employee;

public interface EmployeeService {
	
	public Employee getEmployee(String empId);
	
	public Employee register(Employee employee);
	
	public Employee update(Employee employee);

	public void delete(String empId); 
	

}
