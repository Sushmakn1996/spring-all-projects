package com.te.springboottable.dao;

import org.springframework.data.repository.CrudRepository;

import com.te.springboottable.entity.Employee;

public interface EmployeeDao extends CrudRepository<Employee,String>{
public Employee findByEmpId(String empId);
}
