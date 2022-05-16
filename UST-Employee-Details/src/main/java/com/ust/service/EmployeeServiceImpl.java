package com.ust.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.dao.IEmployeeDao;
import com.ust.model.Employee;
@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	IEmployeeDao epdo;

	@Override
	public String addEmployee(Employee e) {
		// TODO Auto-generated method stub
		epdo.save(e);
		return e.getEmployeeCode();
	}

	@Override
	public void updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		epdo.save(e);
	}

	@Override
	public boolean isPresent(int id) {
		// TODO Auto-generated method stub
		return epdo.existsById(id);
	}

	@Override
	public Optional<Employee> getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return epdo.findById(id);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		epdo.deleteById(id);
	}

	@Override
	public List<Employee> listAllEmployee() {
		// TODO Auto-generated method stub
		return epdo.findAll();
	}

	

}
