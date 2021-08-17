package com.cg.model;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Patient {
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="patient_seq")
@SequenceGenerator(name="patient_seq",sequenceName="patient_seq",allocationSize=1)
@Column(name="patient_Id")
private int patientId;
@Column(name="patient_Name")
private String patientName;
@Column(name="patient_Age")
private int patientAge;
@Column(name="patient_Mobile")
private long patientMobile;
@Column(name="patient_Email")
private String patientEmail;
@Column(name="patient_DOB")
@JsonFormat(pattern="dd-MMM-yyyy")
private Date patientDOB;
@Column(name="patient_User_Name")
private String patientUserName;
@Column(name="patient_Password")
private String patientPassword;
@Column(name="patient_Address")
private String patientAddress;
@OneToMany(targetEntity=Appointment.class,cascade=CascadeType.ALL)
@JoinColumn(name="patient_Id",nullable = false, updatable = false)
private List<Appointment> appointment;
public int getPatientId() {
	return patientId;
}
public void setPatientId(int patientId) {
	this.patientId = patientId;
}
public String getPatientName() {
	return patientName;
}
public void setPatientName(String patientName) {
	this.patientName = patientName;
}
public int getPatientAge() {
	return patientAge;
}
public void setPatientAge(int patientAge) {
	this.patientAge = patientAge;
}
public long getPatientMobile() {
	return patientMobile;
}
public void setPatientMobile(long patientMobile) {
	this.patientMobile = patientMobile;
}
public String getPatientEmail() {
	return patientEmail;
}
public void setPatientEmail(String patientEmail) {
	this.patientEmail = patientEmail;
}
public Date getPatientDOB() {
	return patientDOB;
}
public void setPatientDOB(Date patientDOB) {
	this.patientDOB = patientDOB;
}
public String getPatientUserName() {
	return patientUserName;
}
public void setPatientUserName(String patientUserName) {
	this.patientUserName = patientUserName;
}

public String getPatientPassword() {
	return patientPassword;
}
public void setPatientPassword(String patientPassword) {
	this.patientPassword = patientPassword;
}
public String getPatientAddress() {
	return patientAddress;
}
public void setPatientAddress(String patientAddress) {
	this.patientAddress = patientAddress;
}

public List<Appointment> getAppointment() {
	return appointment;
}
public void setAppointment(List<Appointment> appointment) {
	this.appointment = appointment;
}

public Patient(int patientId, String patientName, int patientAge, long patientMobile, String patientEmail,
		Date patientDOB, String patientUserName, String patientPassword, String patientAddress) {
	super();
	this.patientId = patientId;
	this.patientName = patientName;
	this.patientAge = patientAge;
	this.patientMobile = patientMobile;
	this.patientEmail = patientEmail;
	this.patientDOB = patientDOB;
	this.patientUserName = patientUserName;
	this.patientPassword = patientPassword;
	this.patientAddress = patientAddress;
	//this.appointment=appointment;
}
public Patient(int patientId, String patientName, int patientAge, long patientMobile, String patientEmail
		,String patientAddress) {
	super();
	this.patientId = patientId;
	this.patientName = patientName;
	this.patientAge = patientAge;
	this.patientMobile = patientMobile;
	this.patientEmail = patientEmail;
	this.patientAddress = patientAddress;
}

public Patient() {
	
}
}