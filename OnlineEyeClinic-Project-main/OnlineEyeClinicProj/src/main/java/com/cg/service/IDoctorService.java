package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.Exceptions.DoctorIdNotFoundException;
import com.cg.Exceptions.UserNameAlreadyExistException;
import com.cg.model.Appointment;
import com.cg.model.Doctor;
import com.cg.model.Test;

@Service
public interface IDoctorService {
	//getting list of doctors
	public List<Doctor> viewAllDoctors();
	//adding a doctor
	public Doctor addDoctor(Doctor doctor)throws UserNameAlreadyExistException;
	//updating doctor
	public Doctor updateDoctor(Doctor doctor);
	//deleting a doctor
	public Doctor deleteDoctor(int doctorId)throws DoctorIdNotFoundException;
	//viewing a doctor by individual id
	public Doctor viewDoctor(int doctorId)throws DoctorIdNotFoundException;
	//view all appointments by doctor
	public List<Appointment> viewAllAppointmentsByDoctorId(int doctorId)throws DoctorIdNotFoundException;
	public void createTest(Doctor doctor);
}
