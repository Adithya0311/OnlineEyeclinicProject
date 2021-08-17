package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.Exceptions.PatientIdNotFoundException;
import com.cg.Exceptions.UserNameAlreadyExistException;
import com.cg.model.Appointment;
//import com.cg.model.Appointment;
import com.cg.model.Patient;
import com.cg.model.Report;

@Service
public interface IPatientService{
	//view all patients
	public List<Patient> viewAllPatients();
	// add patient
	public Patient addPatient(Patient patient)throws UserNameAlreadyExistException;
	//book appointment
	public Patient bookAppointmnet(Patient patient);
	//delete appointment
	public Patient deletePatient(int patientId)throws PatientIdNotFoundException;
	//updating patient
	public Patient updatePatient(Patient patient);
	//viewing patient by individual id
	public Patient viewPatient(int patientId)throws PatientIdNotFoundException;
	//viewing appointment by patient
	public List<Appointment> viewAppointmentsByPatient(int patientId)throws PatientIdNotFoundException;
	//viewing report by patient
	public List<Report> viewReportsByPatient(int patientId)throws PatientIdNotFoundException;
}
