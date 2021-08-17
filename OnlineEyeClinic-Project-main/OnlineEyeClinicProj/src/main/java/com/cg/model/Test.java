package com.cg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Test {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="test_seq")
	@SequenceGenerator(name="test_seq",sequenceName="test_seq",allocationSize=1)
	@Column(name="test_Id")
int testId;
	@Column(name="test_Name")
private String testName;
private String test_type;	
	@Column(name="test_Cost")
private double testCost;
	@Column(name="test_Description")
private String testDescriprion;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="doctor_Id",insertable = false,updatable=false)
private Doctor doctor;
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getTest_type() {
		return test_type;
	}
	public void setTest_type(String test_type) {
		this.test_type = test_type;
	}
	public double getTestCost() {
		return testCost;
	}
	public void setTestCost(double testCost) {
		this.testCost = testCost;
	}
	public String getTestDescriprion() {
		return testDescriprion;
	}
	public void setTestDescriprion(String testDescriprion) {
		this.testDescriprion = testDescriprion;
	}
	public Test(int testId, String testName,String test_type, double testCost, String testDescriprion) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.test_type=test_type;
		this.testCost = testCost;
		this.testDescriprion = testDescriprion;
	}
public Test() {
	
}


}
