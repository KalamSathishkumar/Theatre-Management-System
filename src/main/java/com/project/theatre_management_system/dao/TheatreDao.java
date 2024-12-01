package com.project.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.theatre_management_system.dto.Branch;
import com.project.theatre_management_system.dto.Theatre;
import com.project.theatre_management_system.repo.TheatreRepo;

@Repository
public class TheatreDao {

	@Autowired
	TheatreRepo theatreRepo;

	@Autowired
	BranchDao branchDao;

	public Theatre saveTheatre(Theatre theatre) {
		return theatreRepo.save(theatre);
	}

	public Theatre updateTheatreById(int oldTheatreId, Theatre newTheatre) {
		newTheatre.setTheatreId(oldTheatreId);
//	return	theatreRepo.save(newTheatre);
		return saveTheatre(newTheatre);
	}

	public Theatre fetchByTheatreId(int theatreId) {
	   Optional<Theatre> dbTheatre=theatreRepo.findById(theatreId);
	   if(dbTheatre.isPresent()) {
		   return dbTheatre.get();
	   }else {
		   return null;
	   }
	}

	public List<Theatre> fetchAllTheatre() {
		return theatreRepo.findAll();
	}

	public Theatre deleteTheatreById(int theatreId) {
		Theatre theatre = fetchByTheatreId(theatreId);
		theatreRepo.delete(theatre);
		return theatre;
	}

	public Theatre addExistingBranchToExistingTheatre(int branchId, int theatreId) {
		Theatre theatre = fetchByTheatreId(theatreId);
		Branch branch = branchDao.fetchByBranchId(branchId);
		List<Branch> list = theatre.getBranch();
		list.add(branch);
		theatre.setBranch(list);
		return saveTheatre(theatre);
	}

	public Theatre addNewBranchToExistingTheatre(int theatreId, Branch newBranch) {
		Theatre theatre = fetchByTheatreId(theatreId);
	          List<Branch>list=theatre.getBranch();
	          list.add(newBranch);
	          theatre.setBranch(list);
	          return saveTheatre(theatre);
	}

}
