package com.project.theatre_management_system.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Audience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int audienceId;
	private String audienceName;
	private long audiencePhone;
	private int audienceAge;
	private String audienceGender;
	private String audienceEmail;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Food> food;
	
	public int getAudienceId() {
		return audienceId;
	}
	public void setAudienceId(int audienceId) {
		this.audienceId = audienceId;
	}
	public String getAudienceName() {
		return audienceName;
	}
	public void setAudienceName(String audienceName) {
		this.audienceName = audienceName;
	}
	public long getAudiencePhone() {
		return audiencePhone;
	}
	public void setAudiencePhone(long audiencePhone) {
		this.audiencePhone = audiencePhone;
	}
	public int getAudienceAge() {
		return audienceAge;
	}
	public void setAudienceAge(int audienceAge) {
		this.audienceAge = audienceAge;
	}
	public String getAudienceGender() {
		return audienceGender;
	}
	public void setAudienceGender(String audienceGender) {
		this.audienceGender = audienceGender;
	}
	public String getAudienceEmail() {
		return audienceEmail;
	}
	public void setAudienceEmail(String audienceEmail) {
		this.audienceEmail = audienceEmail;
	}
	public List<Food> getFood() {
		return food;
	}
	public void setFood(List<Food> food) {
		this.food = food;
	}
	
	

}
