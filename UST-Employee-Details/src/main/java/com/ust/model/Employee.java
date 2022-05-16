package com.ust.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Employee {
	@Id
	@Column(name="Id")
	@GeneratedValue
private Integer id;
	@Column(name="EmployeeCode",length=50)
private String employeeCode;
	@Column(name="EmployeeName",length=100)
private String employeeName;
	@Column(name="EmployeeDesignation",length=100)
private String employeeDesignation;
	@Column(name="EmployeeDepartment",length=100)
private String employeeDepartment;
	@Column(name="EmployeeAddress",length=500)
private String employeeAddress;

}
