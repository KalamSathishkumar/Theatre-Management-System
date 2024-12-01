package com.project.theatre_management_system.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Owner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ownerId;
	
	@NotBlank(message="Owner cannot be blank")
	@NotNull(message="owner cannot be null")
	@Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]",message="name should be start with Capital Letter")
	private String ownerName;
	private long ownerPhone;
	private String ownerNetworth;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Theatre theatre;
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public long getOwnerPhone() {
		return ownerPhone;
	}
	public void setOwnerPhone(long ownerPhone) {
		this.ownerPhone = ownerPhone;
	}
	public String getOwnerNetworth() {
		return ownerNetworth;
	}
	public void setOwnerNetworth(String ownerNetworth) {
		this.ownerNetworth = ownerNetworth;
	}
	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}
	

	
	
	

}
