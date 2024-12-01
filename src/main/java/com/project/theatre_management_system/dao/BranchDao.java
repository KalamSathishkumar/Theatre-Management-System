package com.project.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.theatre_management_system.dto.Address;
import com.project.theatre_management_system.dto.Branch;
import com.project.theatre_management_system.dto.Employee;
import com.project.theatre_management_system.dto.Manager;
import com.project.theatre_management_system.dto.Screen;
import com.project.theatre_management_system.dto.Theatre;
import com.project.theatre_management_system.repo.BranchRepo;

@Repository
public class BranchDao {

	@Autowired
	BranchRepo branchRepo;

	@Autowired
	ManagerDao managerDao;

	@Autowired
	AddressDao addressDao;

	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	ScreenDao screenDao;

	public Branch saveBranch(Branch branch) {
		return branchRepo.save(branch);
	}

	public Branch updateBranchById(int oldBranchId, Branch newBranch) {
		newBranch.setBranchId(oldBranchId);
//	return	branchRepo.save(newBranch);
		return saveBranch(newBranch);
	}

	public Branch fetchByBranchId(int branchId) {
		Optional<Branch> dbBranch= branchRepo.findById(branchId);
		 if(dbBranch.isPresent()) {
			 return dbBranch.get();
		 }else{
			 return null;
		 }
	}

	public List<Branch> fetchAllBranch() {
		return branchRepo.findAll();
	}

	public Branch deleteBranchById(int branchId) {
		Branch branch = fetchByBranchId(branchId);
		branchRepo.delete(branch);
		return branch;
	}

	public Branch addExistingManagerToExistingBranch(int branchId, int managerId) {
		Branch branch = fetchByBranchId(branchId);
		Manager manager = managerDao.fetchByManagerId(managerId);
		branch.setManager(manager);
		return saveBranch(branch);
	}

	public Branch addNewManagerToExistingBranch(int branchId, Manager newManager) {
		Branch branch = fetchByBranchId(branchId);
		branch.setManager(newManager);
		return saveBranch(branch);
	}

	public Branch addExistingAddressToExistingBranch(int branchId, int addressId) {
		Branch branch = fetchByBranchId(branchId);
		Address address = addressDao.fetchByAddressId(addressId);
		branch.setAddress(address);
		return saveBranch(branch);
	}

	public Branch addNewAddressToExistingBranch(int branchId, Address address) {
		Branch branch = fetchByBranchId(branchId);
		branch.setAddress(address);
		return saveBranch(branch);
	}

	public Branch addExistingEmployeeToExistingBranch(int branchId, int employeeId) {
		Branch branch = fetchByBranchId(branchId);
		Employee employee = employeeDao.fetchByEmployeeId(employeeId);
		List<Employee> list = branch.getEmployee();
		list.add(employee);
		branch.setEmployee(list);
		return saveBranch(branch);
	}

	public Branch addNewEmployeeToExistingBranch(int branchId,Employee employee) {
		   Branch branch= fetchByBranchId(branchId);
		      List<Employee>list=branch.getEmployee();
		      list.add(employee);
	          branch.setEmployee(list);
	          return saveBranch(branch);
	}
	
	
	public Branch addExistingScreenToExistingBranch(int branchId, int screenId) {
		Branch branch = fetchByBranchId(branchId);
	   Screen screen= screenDao.fetchByScreenId(screenId);
		List<Screen> list = branch.getScreen();
		list.add(screen);
	    branch.setScreen(list);
		return saveBranch(branch);
	}

	public Branch addNewScreenToExistingBranch(int branchId,Screen newScreen) {
		   Branch branch= fetchByBranchId(branchId);
		      List<Screen>list=branch.getScreen();
		      list.add(newScreen);
	          branch.setScreen(list);
	          return saveBranch(branch);
	}

}
