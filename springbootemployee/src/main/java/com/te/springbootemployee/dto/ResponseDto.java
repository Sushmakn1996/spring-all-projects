package com.te.springbootemployee.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.te.springbootemployee.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto {
	
	private boolean error;
	private String message;
	private Object object;
	private List<Employee> list;

}
