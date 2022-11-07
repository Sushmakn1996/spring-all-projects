package com.te.springboottable.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class EmployeeDataReturn {
	private String empId;
	private String empAge;
	private String empName;
	private String doj;
}
