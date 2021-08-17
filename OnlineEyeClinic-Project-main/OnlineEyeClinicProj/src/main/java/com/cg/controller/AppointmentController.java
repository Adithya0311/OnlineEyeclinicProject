package com.cg.controller;

import java.util.Date;
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

import com.cg.Exceptions.AppointmentIdNotFoundException;
import com.cg.model.Appointment;
import com.cg.model.Patient;
import com.cg.service.IAppointmentService;
import com.fasterxml.jackson.annotation.JsonFormat;

@RestController
@RequestMapping("appointment/api/v1")
public class AppointmentController {
	@Autowired
	private IAppointmentService as;
	@GetMapping("/appointments")
	public ResponseEntity<List<Appointment>> getAllAppointment(){
		List<Appointment> appointment= as.viewAllAppointments();
		if(appointment.isEmpty()) {
			ResponseEntity.status(204).build();
		}
		
		return new ResponseEntity<List<Appointment>>(appointment, HttpStatus.OK);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/appointments")
	public ResponseEntity<Appointment> insertAppointment(@RequestBody Appointment appoint){
		Appointment appointment= as.bookAppointment(appoint);
		if(appointment==null) {
			return new ResponseEntity("Sorry! appointment not inserted!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/appointments/id/{appointmentId}")
	public ResponseEntity<Appointment> viewAppointment(@PathVariable("appointmentId") Integer appointmentId)throws AppointmentIdNotFoundException{
		Appointment appointment= as.viewAppointment(appointmentId);
		if(appointment==null) {
			return new ResponseEntity("Sorry! appointment not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
    @DeleteMapping("/appointments/{appointmentId}")
	public ResponseEntity<Appointment> deleteAppointment(
			@PathVariable("appointmentId")Integer appointmentId)throws AppointmentIdNotFoundException{
		Appointment appointment= as.cancelAppointment(appointmentId);
		if(appointment==null) {
			return new ResponseEntity("Sorry! appointment not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
    @PutMapping("/appointments")
	public ResponseEntity<Appointment> updateAppointment(
			@RequestBody Appointment appoint){
		Appointment appointment= as.updateAppointment(appoint);
		if(appointment==null) {
			return new ResponseEntity("Sorry! appointment not updated!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/appointments/{date}")
	public ResponseEntity<List<Appointment>> viewAppointmentByDate(@PathVariable("date")Date date){
		List<Appointment> appointment= as.viewAppointments(date);
		if(appointment.isEmpty()) {
			return new ResponseEntity("Sorry! appointment not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Appointment>>(appointment, HttpStatus.OK);
	}
}
