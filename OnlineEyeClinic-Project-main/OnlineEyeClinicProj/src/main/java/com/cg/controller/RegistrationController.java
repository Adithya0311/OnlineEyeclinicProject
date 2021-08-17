package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Exceptions.UserNameAlreadyExistException;
import com.cg.model.Admin;
import com.cg.model.Doctor;
import com.cg.model.Patient;
import com.cg.service.IRegistrationService;

@RestController
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private IRegistrationService rs;
	@PostMapping("/patient")
	public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient) throws UserNameAlreadyExistException
	{
		return new ResponseEntity<Patient>(rs.registerPatient(patient),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/doctor")
	public ResponseEntity<Doctor> registerDoctor(@RequestBody Doctor doctor) throws UserNameAlreadyExistException
	{
		return new ResponseEntity<Doctor>(rs.registerDoctor(doctor),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/admin")
	public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) throws UserNameAlreadyExistException
	{
		return new ResponseEntity<Admin>(rs.registerAdmin(admin),HttpStatus.ACCEPTED);
	}
}
