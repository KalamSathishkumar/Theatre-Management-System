package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.EmployeeDao;
import com.project.theatre_management_system.dto.Employee;
import com.project.theatre_management_system.exception.EmployeeIdNotFound;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	ResponseStructure<Employee> responseStructure;
	
	@Autowired
	ResponseStructureList<Employee> responseStructureList;
	
	public ResponseStructure<Employee> saveEmployee(Employee employee) {
	 responseStructure.setStatusCode(HttpStatus.CREATED.value());
	 responseStructure.setMessage("Successfully data is inserted in the DB");
	 responseStructure.setData(employeeDao.saveEmployee(employee));
	return responseStructure;
	}
	
	public ResponseStructure<Employee> updateEmployeeById(int oldEmployeeId, Employee newEmployee) {
		  Employee employee=employeeDao.fetchByEmployeeId(oldEmployeeId);
	       if(employee !=null) {
		 responseStructure.setStatusCode(HttpStatus.OK.value());
		 responseStructure.setMessage("Successfully data is updated in the DB");
		 responseStructure.setData(employeeDao.updateEmployeeById(oldEmployeeId, newEmployee));
		return responseStructure;
	       }else {
	    	   throw new EmployeeIdNotFound();
	       }
 
	}
	
	public ResponseStructure<Employee> fetchByEmployeeId(int employeeId) {
		       Employee employee=employeeDao.fetchByEmployeeId(employeeId);
		       if(employee !=null) {
		 responseStructure.setStatusCode(HttpStatus.FOUND.value());
		 responseStructure.setMessage("Successfully data is fetched in the DB");
		 responseStructure.setData(employeeDao.fetchByEmployeeId(employeeId));
		return responseStructure;
		       }else {
		    	   throw new EmployeeIdNotFound();
		       }
	}
	
	public ResponseStructureList<Employee> fetchAllEmployee(){
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("successfully data is fetched from DB");
		responseStructureList.setData(employeeDao.fetchAllEmployee());
		return responseStructureList;
	}
	
	public ResponseStructure<Employee> deleteEmployeeById(int employeeId) {
		  Employee employee=employeeDao.fetchByEmployeeId(employeeId);
	       if(employee !=null) {
		 responseStructure.setStatusCode(HttpStatus.OK.value());
		 responseStructure.setMessage("Successfully data is deleted from the DB");
		 responseStructure.setData(employeeDao.deleteEmployeeById(employeeId));
		return responseStructure;
	       }else {
	    	   throw new EmployeeIdNotFound();
	       }
	}

}
