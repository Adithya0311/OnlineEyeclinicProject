package com.cg.service;

import org.springframework.stereotype.Service;

import com.cg.Exceptions.UserNameAlreadyExistException;
import com.cg.model.Admin;
import com.cg.model.Doctor;
import com.cg.model.Patient;

@Service
public interface IRegistrationService {
	//patient registration
	public Patient registerPatient(Patient patient)throws UserNameAlreadyExistException; 
    //doctor registration
	public Doctor registerDoctor(Doctor doctor)throws UserNameAlreadyExistException; 
    //admin registration
	public Admin registerAdmin(Admin admin) throws UserNameAlreadyExistException; 
}
