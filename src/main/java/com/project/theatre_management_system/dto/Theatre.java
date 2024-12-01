package com.project.theatre_management_system.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Theatre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int theatreId;
	private String theatreName;
	private String theatreEmail;
	private long theatrePhone;
	private String theatreGST;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Branch> branch;
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getTheatreEmail() {
		return theatreEmail;
	}
	public void setTheatreEmail(String theatreEmail) {
		this.theatreEmail = theatreEmail;
	}
	public long getTheatrePhone() {
		return theatrePhone;
	}
	public void setTheatrePhone(long theatrePhone) {
		this.theatrePhone = theatrePhone;
	}
	public String getTheatreGST() {
		return theatreGST;
	}
	public void setTheatreGST(String theatreGST) {
		this.theatreGST = theatreGST;
	}
	public List<Branch> getBranch() {
		return branch;
	}
	public void setBranch(List<Branch> branch) {
		this.branch = branch;
	}

	
	
	

}
