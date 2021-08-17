package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Exceptions.PatientIdNotFoundException;
import com.cg.Exceptions.UserNameAlreadyExistException;
import com.cg.model.Appointment;
import com.cg.model.Patient;
import com.cg.model.Report;
import com.cg.service.IPatientService;

@RestController
@RequestMapping("patient/api/v1")
public class PatientController {
    //AutoWired Service Layer
	@Autowired
	private IPatientService ps;
    @GetMapping("/patients")
	public ResponseEntity<List<Patient>> getAllPatient(){
		List<Patient> patient= ps.viewAllPatients();
		return new ResponseEntity<List<Patient>>(patient, HttpStatus.OK);
	}
    
	//adding patients
    @PostMapping("/patients")
	public ResponseEntity<Patient> InsertPatient(@RequestBody Patient patients)throws UserNameAlreadyExistException{
		Patient patient= ps.addPatient(patients);		
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}
    
    //removing patient by id
    @DeleteMapping("/patients/{patientId}")
	public ResponseEntity<Patient> deletePatient(
			@PathVariable("patientId")Integer patientId)throws PatientIdNotFoundException{
		Patient patient= ps.deletePatient(patientId);
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}
   
	//booking appointment
    @PostMapping("/bookAppointment")
	public ResponseEntity<Patient> insertAppointment(@RequestBody Patient patients){
		Patient patient= ps.bookAppointmnet(patients);	
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}
    //finding patient by patient Id
    @GetMapping("/patients/{patientId}")
	public ResponseEntity<Patient> findPatient(
			@PathVariable("patientId")Integer patientId)throws PatientIdNotFoundException{
		Patient patient= ps.viewPatient(patientId);
		
		
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}
    //updating patient details
    @PutMapping("/patients")
	public ResponseEntity<Patient> updatePatient(
			 @RequestBody Patient patient){
		Patient patients= ps.updatePatient(patient);
		
		return new ResponseEntity<Patient>(patients, HttpStatus.OK);
	}
    //show appointments by patientId
    @GetMapping("/getAppointments/{patientId}")
	public ResponseEntity<List<Appointment>> findAppointmentByPatient(
			@PathVariable("patientId")Integer patientId)throws PatientIdNotFoundException{
		List<Appointment> appoint= ps.viewAppointmentsByPatient(patientId);
	
		
		return new ResponseEntity<List<Appointment>>(appoint, HttpStatus.OK);
	}
    //getting reports by patient id
    @GetMapping("/getReports/{patientId}")
	public ResponseEntity<List<Report>> findReportsByPatient(
			@PathVariable("patientId")Integer patientId)throws PatientIdNotFoundException{
		List<Report> report= ps.viewReportsByPatient(patientId);
		
		
		return new ResponseEntity<List<Report>>(report, HttpStatus.OK);
	}
}
