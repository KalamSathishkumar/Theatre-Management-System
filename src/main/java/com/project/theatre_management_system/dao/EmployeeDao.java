package com.project.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.theatre_management_system.dto.Employee;
import com.project.theatre_management_system.repo.EmployeeRepo;

@Repository
public class EmployeeDao {
	
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	public Employee saveEmployee(Employee employee) {
	return employeeRepo.save(employee);
	}
	
	public Employee updateEmployeeById(int oldEmployeeId, Employee newEmployee) {
		newEmployee.setEmployeeId(oldEmployeeId);
//	return	employeeRepo.save(newEmployee);
	return	saveEmployee(newEmployee);
	}
	
	public Employee fetchByEmployeeId(int employeeId) {
	Optional<Employee> dbEmployee=	employeeRepo.findById(employeeId);
	if(dbEmployee.isPresent()) {
		return dbEmployee.get();
	}else {
		return null;
	}
	
	}
	
	public List<Employee> fetchAllEmployee(){
		return employeeRepo.findAll();
	}
	
	public Employee deleteEmployeeById(int employeeId) {
		Employee employee=fetchByEmployeeId(employeeId);
		employeeRepo.delete(employee);
		return employee;
	}

}
