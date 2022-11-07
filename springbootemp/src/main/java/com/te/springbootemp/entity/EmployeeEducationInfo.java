package com.te.springbootemp.entity;

import javax.persistence.CascadeType;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;


@Data
@Entity
@Table(name="emp_education_info")
public class EmployeeEducationInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eduId;
	private String Qualification;
	private String Marks;
	private String empYop;
	private String universityBoard;
	private String instituteName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private EmployeePrimaryInfo primaryInfo;
	
	
}