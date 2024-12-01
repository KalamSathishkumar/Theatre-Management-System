package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.AddressDao;
import com.project.theatre_management_system.dao.BranchDao;
import com.project.theatre_management_system.dao.EmployeeDao;
import com.project.theatre_management_system.dao.ManagerDao;
import com.project.theatre_management_system.dao.ScreenDao;
import com.project.theatre_management_system.dto.Address;
import com.project.theatre_management_system.dto.Branch;
import com.project.theatre_management_system.dto.Employee;
import com.project.theatre_management_system.dto.Manager;
import com.project.theatre_management_system.dto.Screen;
import com.project.theatre_management_system.exception.AddressIdNotFound;
import com.project.theatre_management_system.exception.BranchIdNotFound;
import com.project.theatre_management_system.exception.EmployeeIdNotFound;
import com.project.theatre_management_system.exception.ManagerIdNotFound;
import com.project.theatre_management_system.exception.ScreenIdNotFound;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class BranchService {
	
	@Autowired
	BranchDao branchDao;
	
	@Autowired
	ResponseStructure<Branch> responseStructure;
	
	@Autowired
	ResponseStructureList<Branch> responseStructureList;
	
	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	ScreenDao screenDao;
	
	public ResponseStructure<Branch> saveBranch(Branch branch) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully data is inserted in the databasse");
		responseStructure.setData(branchDao.saveBranch(branch));
	return responseStructure;
	}
	
	public ResponseStructure<Branch> updateBranchById(int oldBranchId, Branch newBranch) {
		Branch branch=branchDao.fetchByBranchId(oldBranchId);
		if(branch != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully data is updated in the databasse");
		responseStructure.setData(branchDao.updateBranchById(oldBranchId, newBranch));
	return responseStructure;
		}else {
			throw new BranchIdNotFound();
		}
  
	}
	
	public ResponseStructure<Branch> fetchByBranchId(int branchId) {
		Branch branch=branchDao.fetchByBranchId(branchId);
		if(branch != null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully data is fetched from the databasse");
		responseStructure.setData(branchDao.fetchByBranchId(branchId));
	return responseStructure;
		}else {
			throw new BranchIdNotFound();
		}
		
	}
	
	public ResponseStructureList<Branch> fetchAllBranch(){
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("successfully data is fetched from DB");
		responseStructureList.setData(branchDao.fetchAllBranch());
		return responseStructureList;
	}
	
	public ResponseStructure<Branch> deleteBranchById(int branchId) {
		Branch branch=branchDao.fetchByBranchId(branchId);
		if(branch != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully data is deleted from the databasse");
		responseStructure.setData(branchDao.deleteBranchById(branchId));
	return responseStructure;
		}else {
			throw new BranchIdNotFound();
		}
	}
	
	public ResponseStructure<Branch> addExistingManagerToExistingBranch(int managerId,int branchId) {
		         Branch branch=branchDao.fetchByBranchId(branchId);
		          Manager manager=managerDao.fetchByManagerId(managerId);
		      if(branch !=null ) {
		    	  if(manager !=null) {
		    		  
		    		  responseStructure.setStatusCode(HttpStatus.OK.value());
		    		  responseStructure.setMessage("Successsfully Added");
		    		  responseStructure.setData(branchDao.addExistingManagerToExistingBranch(managerId, branchId));
		    		  return  responseStructure;
		    	  }else {
		    		  throw new ManagerIdNotFound();
		    	  }
		      }else {
		    	  throw new BranchIdNotFound();
		      }
		         
	}
	public ResponseStructure<Branch> addNewManagerToExistingBranch(int branchId,Manager newManager) {
		     Branch branch = branchDao.fetchByBranchId(branchId);
		     if(branch !=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successsfully Added");
		responseStructure.setData(branchDao.addNewManagerToExistingBranch(branchId, newManager));
   return  responseStructure;
	}  else {
		throw new BranchIdNotFound();
	}
	}
	
	
	public ResponseStructure<Branch> addExistingAddressToExistingBranch(int branchId,int addressId) {
	     Branch branch = branchDao.fetchByBranchId(branchId);
	    Address address= addressDao.fetchByAddressId(addressId);
            
	      if(branch !=null) {
	    	  if(address !=null) {
	    		  
	    		  responseStructure.setStatusCode(HttpStatus.OK.value());
	    		  responseStructure.setMessage("Successsfully Added");
	    		  responseStructure.setData(branchDao.addExistingAddressToExistingBranch(branchId, addressId));
	    		  return  responseStructure;
	    	  }else {
	    		  throw new AddressIdNotFound();
	    	  }
	      }else {
	    	  throw new BranchIdNotFound();
	      }
	}
	
	public ResponseStructure<Branch> addNewAddressToExistingBranch(int branchId,Address address) {
	     Branch branch = branchDao.fetchByBranchId(branchId);
            if(branch !=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successsfully Added");
		responseStructure.setData(branchDao.addNewAddressToExistingBranch(branchId, address));
   return  responseStructure;
            }else {
            	throw new BranchIdNotFound();
            }
	}
	
	public ResponseStructure<Branch> addExistingEmployeeToExistingBranch(int branchId, int employeeId) {
	     Branch branch = branchDao.fetchByBranchId(branchId);
        Employee employee=   employeeDao.fetchByEmployeeId(employeeId);
		 if(branch !=null) {
			 if(employee !=null) {
				 
				 responseStructure.setStatusCode(HttpStatus.OK.value());
				 responseStructure.setMessage("Successsfully Added");
				 responseStructure.setData(branchDao.addExistingEmployeeToExistingBranch(branchId, employeeId));
				 return  responseStructure;
			 }else {
				 throw new EmployeeIdNotFound();
			 }
		 }else {
			 throw new BranchIdNotFound();
		 }
	}

	public ResponseStructure<Branch> addNewEmployeeToExistingBranch(int branchId,Employee employee) {
	     Branch branch = branchDao.fetchByBranchId(branchId);
     if(branch !=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successsfully Added");
		responseStructure.setData(branchDao.addNewEmployeeToExistingBranch(branchId, employee));
   return  responseStructure;
     }else {
    	 throw new BranchIdNotFound();
     }
		
	}
	
	public ResponseStructure<Branch> addExistingScreenToExistingBranch(int branchId, int screenId) {
	     Branch branch = branchDao.fetchByBranchId(branchId);
             Screen screen= screenDao.fetchByScreenId(screenId);
             if(branch !=null) {
            	 if(screen !=null) {
            		 
            		 responseStructure.setStatusCode(HttpStatus.OK.value());
            		 responseStructure.setMessage("Successsfully Added");
            		 responseStructure.setData(branchDao.addExistingScreenToExistingBranch(branchId, screenId));
            		 return  responseStructure;
            	 }else {
            		 throw new ScreenIdNotFound();
            	 }
             }else {
            	 throw new BranchIdNotFound();
             }
	}
	public ResponseStructure<Branch> addNewScreenToExistingBranch(int branchId,Screen newScreen) {
	     Branch branch = branchDao.fetchByBranchId(branchId);
             if(branch !=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successsfully Added");
		responseStructure.setData(branchDao.addNewScreenToExistingBranch(branchId, newScreen));
   return  responseStructure;
	}else {
		throw new BranchIdNotFound();
	}
	
}
}
