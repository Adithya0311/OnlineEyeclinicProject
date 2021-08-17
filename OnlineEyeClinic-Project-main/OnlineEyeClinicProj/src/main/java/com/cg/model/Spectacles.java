package com.cg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Spectacles {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="spectacles_seq")
	@SequenceGenerator(name="spectacles_seq",sequenceName="spectacles_seq",allocationSize=1)
	@Column(name="spectacles_Id")
private int spectaclesId;
	@Column(name="spectacles_Number")
private String spectaclesNumber;
	@Column(name="spectacles_Model")
private String spectaclesModel;
	@Column(name="spectacles_Description")
private String spectaclesDescription;
	@Column(name="spectacles_Cost")
private double spectaclesCost;
	public int getSpectaclesId() {
		return spectaclesId;
	}
	public void setSpectaclesId(int spectaclesId) {
		this.spectaclesId = spectaclesId;
	}
	public String getSpectaclesNumber() {
		return spectaclesNumber;
	}
	public void setSpectaclesNumber(String spectaclesNumber) {
		this.spectaclesNumber = spectaclesNumber;
	}
	public String getSpectaclesModel() {
		return spectaclesModel;
	}
	public void setSpectaclesModel(String spectaclesModel) {
		this.spectaclesModel = spectaclesModel;
	}
	public String getSpectaclesDescription() {
		return spectaclesDescription;
	}
	public void setSpectaclesDescription(String spectaclesDescription) {
		this.spectaclesDescription = spectaclesDescription;
	}
	public double getSpectaclesCost() {
		return spectaclesCost;
	}
	public void setSpectaclesCost(double spectaclesCost) {
		this.spectaclesCost = spectaclesCost;
	}
	public Spectacles() {
		
	}
}
