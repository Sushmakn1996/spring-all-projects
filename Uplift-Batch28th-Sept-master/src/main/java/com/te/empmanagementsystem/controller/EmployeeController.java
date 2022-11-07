package com.te.empmanagementsystem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.empmanagementsystem.entity.Employee;
import com.te.empmanagementsystem.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	
	@GetMapping("/register")
	public String getRegistrationForm() {
		return "registrationForm";
	}

	@GetMapping("/login")
	public String getLoginForm() {
		return "loginForm";
	}

	@PostMapping("/register")
	public String register(Employee employee, ModelMap map) {
		if (employee != null) {
			if (service.register(employee)) {
				map.addAttribute("msg", "Registration Successful!");
			} else {
				map.addAttribute("errMsg", "Something went wrong");
			}
		}
		return "registrationForm";
	}

	@PostMapping("/login")
	public String authenticate(Employee employee, ModelMap map, HttpServletRequest request) {
		if (employee != null && (!employee.getEmpId().isEmpty() || !employee.getPassword().isEmpty())) {
			Employee employee2 = service.authenticate(employee);
			if (employee2 != null) {
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(50);
				session.setAttribute("loggedIn", employee2);
				map.addAttribute("name", employee2.getEmpName());
				return "welcome";
			} else {
				map.addAttribute("errMsg", "Invalid credentials");
			}
		} else {
			map.addAttribute("errMsg", "Please enter something!");
		}
		return "loginForm";
	}

	@GetMapping("/delete")
	public String getDeleteForm(ModelMap map,
			@SessionAttribute(name = "loggedIn", required = false) Employee employee) {
		if (employee != null) {
			map.addAttribute("empId", employee.getEmpId());
			return "deleteForm";
		}
		map.addAttribute("errMsg", "Please login first");
		return "loginForm";
	}

	@PostMapping("/delete")
	public String deleteEmployee(ModelMap map,
			@SessionAttribute(name = "loggedIn", required = false) Employee employee) {
		if (employee != null) {
			service.deleteEmployee(employee.getEmpId());
			map.addAttribute("errMsg", "Account deleted!");
			return "registrationForm";
		}
		map.addAttribute("errMsg", "Please login first");
		return "loginForm";
	}

	@GetMapping("/update")
	public String getUpdateForm(ModelMap map,
			@SessionAttribute(name="loggedIn", required = false) Employee employee) {
		if(employee!=null) {
			map.addAttribute("empId", employee.getEmpId());
		
			return "updateForm";
		}
		return "loginForm";
	}
	
	@PostMapping("/update")
	public String updateEmployee(ModelMap map,@SessionAttribute(name = "loggedIn", required = false) Employee employee,Employee employee2, HttpSession session) {
		if (employee != null) {
			if(service.updateEmployee(employee,employee2)) {
				map.addAttribute("errMsg", "Account is updated successfully!");
				if(session!=null) {
					session.removeAttribute("loggedIn");
					return "updateForm";
				}
				return "loginForm";
			}
		}
		return "loginForm";
	}
	
	@GetMapping("/mydetails")
	public String myDetails(ModelMap map,Employee employee) {
		if(employee!=null) {
			map.addAttribute("empId", employee.getEmpId());
			map.addAttribute("empName", employee.getEmpName());
			map.addAttribute("emailId", employee.getEmailId());
			return "myDetails";
		}
		map.addAttribute("errMsg", "Please login first");
		return "loginForm";
	}
	
	@GetMapping("/alldetails")
	public String getAllDetails(ModelMap map){
			List<Employee> allDetails = service.getAllDetails();
			map.addAttribute("allrecords", allDetails);
			return "allDetails";
			
		}
	
		
	
	
	@GetMapping("/logout")
	public String logout(ModelMap map, HttpSession session) {
		session.invalidate();
		map.addAttribute("errMsg", "Logged out successfully!");
		return "loginForm";
	}

}
