package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.ManagerDao;
import com.project.theatre_management_system.dto.Manager;
import com.project.theatre_management_system.exception.ManagerIdNotFound;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class ManagerService {
	
	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	ResponseStructure<Manager> responseStructure;
	
	@Autowired
	ResponseStructureList<Manager> responseStructureList;
	
	public ResponseStructure<Manager> saveManager(Manager manager) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("succesfully data is inserted into DB");
		responseStructure.setData(managerDao.saveManager(manager));
	   return responseStructure;
	}
	
	public ResponseStructure<Manager> updateManagerById(int oldManagerId, Manager newManager) {
	    Manager manager= managerDao.fetchByManagerId(oldManagerId);  
	    if(manager !=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("succesfully data is updated in DB");
		responseStructure.setData(managerDao.updateManagerById(oldManagerId, newManager));
	   return responseStructure;
	    }else {
	    	throw new ManagerIdNotFound();
	    }
	}
	
	public ResponseStructure<Manager> fetchByManagerId(int managerId) {
		    Manager manager= managerDao.fetchByManagerId(managerId);  
		    if(manager !=null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("succesfully data is fetched from DB");
		responseStructure.setData(managerDao.fetchByManagerId(managerId));
	   return responseStructure;
		    }else {
		    	throw new ManagerIdNotFound();
		    }
	}
	
	public ResponseStructureList<Manager> fetchAllManager(){
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("successfully data is fetched from DB");
		responseStructureList.setData(managerDao.fetchAllManager());
		return responseStructureList;
	}
	
	public ResponseStructure<Manager> deleteManagerById(int managerId) {
	    Manager manager= managerDao.fetchByManagerId(managerId);  
	    if(manager !=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("succesfully data is deleted from DB");
		responseStructure.setData(managerDao.deleteManagerById(managerId));
	   return responseStructure;
	    }else {
	    	throw new ManagerIdNotFound();
	    }

	}

}
