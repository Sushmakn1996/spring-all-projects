package com.te.empmanagementsystem.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.empmanagementsystem.entity.Employee;
import com.te.empmanagementsystem.exception.EmployeeNotPresentException;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public boolean register(Employee employee) {
		boolean isRegistered = false;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(employee);
			transaction.commit();
			isRegistered = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isRegistered;
	}

	@Override
	public Employee authenticate(Employee employee) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
		EntityManager manager = factory.createEntityManager();
		Employee employee2 = manager.find(Employee.class, employee.getEmpId());
		if (employee2 != null) {
			if (employee.getPassword().equals(employee2.getPassword())) {
				return employee2;
			} else {
				throw new EmployeeNotPresentException("Incorrect password");
			}
		} else {
			throw new EmployeeNotPresentException("Incorrect ID");
		}
	}

	@Override
	public boolean deleteEmployee(String id) {
		boolean isDeleted = false;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Employee employee = manager.find(Employee.class, id);
			manager.remove(employee);
			transaction.commit();
			isDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	@Override
	public boolean updateEmployee(Employee employee, Employee employee2) {
		boolean isDeleted = false;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Employee employee3 = manager.find(Employee.class, employee.getEmpId());
			employee3.setEmpName(employee2.getEmpName());
			employee3.setEmailId(employee2.getEmailId());
			employee3.setPassword(employee2.getPassword());
			transaction.commit();
			isDeleted = true;
			return isDeleted;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	@Override
	public List getAllDetails() {
		List resultList = null;

		try {

			EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
			EntityManager manager = factory.createEntityManager();
			String string = "from Employee";
			Query query = manager.createQuery(string);
			resultList = query.getResultList();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return resultList;

	}
}
