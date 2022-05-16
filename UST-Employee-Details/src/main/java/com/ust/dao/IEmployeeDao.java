package com.ust.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.model.Employee;

@Repository
public interface IEmployeeDao extends JpaRepository<Employee, Integer>{

}
