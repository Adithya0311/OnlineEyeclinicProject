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

import com.cg.Exceptions.DoctorIdNotFoundException;
import com.cg.Exceptions.UserNameAlreadyExistException;
import com.cg.model.Appointment;
import com.cg.model.Doctor;
import com.cg.model.Patient;
import com.cg.service.IDoctorService;

@RestController
@RequestMapping("doctor/api/v1")
public class DoctorController {

	@Autowired
	private IDoctorService ds;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/doctors")
	public ResponseEntity<List<Doctor>> getAllDoctor(){
		List<Doctor> doctor= ds.viewAllDoctors();
		if(doctor.isEmpty()) {
			return new ResponseEntity("Sorry! doctors not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Doctor>>(doctor, HttpStatus.OK);
	}
	 @SuppressWarnings({ "rawtypes", "unchecked" })
		@PostMapping("/doctors")
		public ResponseEntity<Doctor> InsertDoctor(@RequestBody Doctor doctor)throws UserNameAlreadyExistException{
		  Doctor doctors= ds.addDoctor(doctor);
			if(doctors==null) {
				return new ResponseEntity("Sorry! doctor not inserted!", 
						HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<Doctor>(doctors, HttpStatus.OK);
		}
	 @SuppressWarnings({ "rawtypes", "unchecked" })
		@PutMapping("/doctors")
		public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor){
			Doctor doctors= ds.updateDoctor(doctor);
			if(doctors==null) {
				return new ResponseEntity("Sorry! doctor not updated!", 
						HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<Doctor>(doctors, HttpStatus.OK);
		}
	 @SuppressWarnings({ "rawtypes", "unchecked" })
		@GetMapping("/doctors/{doctorId}")
		public ResponseEntity<Doctor> findDoctor(@PathVariable("doctorId")Integer doctorId)throws DoctorIdNotFoundException{
			Doctor doctor=ds.viewDoctor(doctorId);
			if(doctor==null) {
				return new ResponseEntity("Sorry! doctor not found!", 
						HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
		}
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	    @DeleteMapping("/doctors/{doctorId}")
		public ResponseEntity<Doctor> deleteDoctor(
				@PathVariable("doctorId")Integer doctorId)throws DoctorIdNotFoundException{
			Doctor doctor= ds.deleteDoctor(doctorId);
			if(doctor==null) {
				return new ResponseEntity("Sorry! doctor not available!", 
						HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
		}
	 @SuppressWarnings({ "rawtypes", "unchecked" })
		@GetMapping("/getAppointments/{doctorId}")
		public ResponseEntity<List<Appointment>> viewAppointments(@PathVariable("doctorId")Integer doctorId)throws DoctorIdNotFoundException{
			List<Appointment> appoint=ds.viewAllAppointmentsByDoctorId(doctorId);
			if(appoint.isEmpty()) {
				return new ResponseEntity("Sorry! appointments not found!", 
						HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<List<Appointment>>(appoint, HttpStatus.OK);
		}
	 //@SuppressWarnings({ "rawtypes", "unchecked" })
		@PostMapping("/createTest")
		public void InsertTest(@RequestBody Doctor doctor){
			 ds.createTest(doctor);
			
		}
}
