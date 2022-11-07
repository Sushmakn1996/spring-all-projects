package com.te.springbootemp.dto;

import javax.persistence.Id;
import lombok.Data;

@Data
public class EmployeeLoginDto {
	
	@Id
	private String empId;
	private String password;
	
	

}
