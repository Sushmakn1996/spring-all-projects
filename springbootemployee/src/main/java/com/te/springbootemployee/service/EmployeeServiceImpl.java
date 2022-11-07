package com.te.springbootemployee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springbootemployee.dao.EmployeeDao;
import com.te.springbootemployee.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;

	@Override
	public List<Employee> getEmployee() {
		return (List<Employee>) dao.findAll();
	}

	@Override
	public Employee register(Employee employee) {
		if (employee.getEmpId().startsWith("TYC")) {
			return dao.save(employee);
		}
		return null;
	}

	@Override
	public Employee login(Employee employee) {
		if (employee.getEmpId().startsWith("TYC")) {
		Employee employee2 = dao.findByEmpId(employee.getEmpId());
		if (employee2 != null && employee2.getPassword().equals(employee.getPassword())) {
			return employee2;
		}
		}
		return null;
	}

}
