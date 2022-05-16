package com.ust.service;

import java.util.List;
import java.util.Optional;

import com.ust.model.Employee;


public interface IEmployeeService {
	
		public String addEmployee(Employee e);
		public void updateEmployee(Employee e);
		public boolean isPresent(int id);
		public Optional<Employee> getEmployeeById(int d);
		public void deleteById(int id);
		public List<Employee> listAllEmployee();
}
