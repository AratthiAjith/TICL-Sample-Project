package com.ust.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.model.Employee;


import com.ust.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
@Autowired
IEmployeeService emps;

@PostMapping("/add")
	public ResponseEntity<String> addEmployee(@RequestBody Employee emp){
	String code=	emps.addEmployee(emp);
	String msg= "EmployeeCode " +code +" inserted successfully";
	return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee emp){
		String mg;
		boolean bobj=emps.isPresent(emp.getId());
		if(bobj) {
			emps.updateEmployee(emp);
			mg= "Employee Record updated  Successfully ";
			return new ResponseEntity<String>(mg,HttpStatus.OK);
		}else {		
			mg= "No DataFound Based on EmpId ";
			return new ResponseEntity<String>(mg,HttpStatus.OK);
		}	
	}
		@GetMapping("/search/{id}")
		public Optional<Employee> searchEmployeeById(@PathVariable int id){
			Optional<Employee> eobj=emps.getEmployeeById(id);
			return eobj;
		}
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> deleteEmployeeById(@PathVariable int id){
			String mg;
			boolean bobj=emps.isPresent(id);
			if(bobj) {
				emps.deleteById(id);
				mg= "Employee Record Deleted  Successfully ";
				return new ResponseEntity<String>(mg,HttpStatus.OK);
			}else {		
				mg= "No DataFound Based on EmpId "+id;
				return new ResponseEntity<String>(mg,HttpStatus.OK);
			}	
		}
		
		@GetMapping("/list")
		public List<Employee> getAllEmpRecords(){
			return emps.listAllEmployee();
		}
		
}
