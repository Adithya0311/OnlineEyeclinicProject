package com.cg.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
//import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@Entity
public class Report {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="report_seq")
	@SequenceGenerator(name="report_seq",sequenceName="report_seq",allocationSize=1)
	@Column(name="REPORT_ID")
private int reportId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy")
	@Column(name="DATE_OF_REPORT")
private Date dateOfReport;
	@Column(name="DESCRIPTION_OF_REPORT")
private String description;
	@Column(name="visual_Acuity")
private String visualAcuity;
	@Column(name="visual_Acuity_For_Near")
private String visualAcuityForNear;
	@Column(name="visual_Acuity_For_Distance")
private String visualAcuityForDistance;
	@OneToOne
	@JoinColumn(name="patient_Id")
private Patient patient;
	@OneToOne
	@JoinColumn(name="test_Id")
private Test test;
	
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public Date getDateOfReport() {
		return dateOfReport;
	}
	public void setDateOfReport(Date dateOfReport) {
		this.dateOfReport = dateOfReport;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVisualAcuity() {
		return visualAcuity;
	}
	public void setVisualAcuity(String visualAcuity) {
		this.visualAcuity = visualAcuity;
	}
	public String getVisualAcuityForNear() {
		return visualAcuityForNear;
	}
	public void setVisualAcuityForNear(String visualAcuityForNear) {
		this.visualAcuityForNear = visualAcuityForNear;
	}
	public String getVisualAcuityForDistance() {
		return visualAcuityForDistance;
	}
	public void setVisualAcuityForDistance(String visualAcuityForDistance) {
		this.visualAcuityForDistance = visualAcuityForDistance;
	}
	public Test getTest() {
		return test;
	}
	
	public Patient getPatient() {
	
	 return patient;
		//return new Patient(patient.getPatientId(),patient.getPatientName(),patient.getPatientAge(),patient.getPatientMobile(),
		//patient.getPatientEmail(),patient.getPatientAddress()
			//	);
	}
	public Report(int reportId, Date dateOfReport, String description, String visualAcuity,
			String visualAcuityForNear, String visualAcuityForDistance, Patient patient, Test test) {
		super();
		this.reportId = reportId;
		this.dateOfReport = dateOfReport;
		this.description = description;
		this.visualAcuity = visualAcuity;
		this.visualAcuityForNear = visualAcuityForNear;
		this.visualAcuityForDistance = visualAcuityForDistance;
		this.patient = patient;
		this.test = test;
	}
public Report() {
	
}
}
