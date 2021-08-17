package com.cg.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Exceptions.AppointmentIdNotFoundException;
import com.cg.dao.IAppointmentRepo;
import com.cg.model.Appointment;
import com.fasterxml.jackson.annotation.JsonFormat;

@Service
public class AppointmentServiceImpl implements IAppointmentService{

	@Autowired
	private IAppointmentRepo appointRepo;

	@Override
	public List<Appointment> viewAllAppointments() {
		// TODO Auto-generated method stub
		return appointRepo.findAll();
	}

	@Override
	public Appointment bookAppointment(Appointment appoint) {
		// TODO Auto-generated method stub
		return appointRepo.saveAndFlush(appoint);
		
	}


	@Override
	public Appointment cancelAppointment(int appointmentId)throws AppointmentIdNotFoundException {
		// TODO Auto-generated method stub
		Supplier<AppointmentIdNotFoundException> supplier=()-> new AppointmentIdNotFoundException("No appointment is available with the given id");
	     Optional<Appointment> appoint=Optional.ofNullable(appointRepo.findById(appointmentId).orElseThrow(supplier));
	     appointRepo.deleteById(appointmentId);
	     return appoint.get();
	}

	@Override
	public Appointment viewAppointment(int appointmentId)throws AppointmentIdNotFoundException {
		// TODO Auto-generated method stub
		Supplier<AppointmentIdNotFoundException> supplier=()-> new AppointmentIdNotFoundException("No appointment is available with the given id");
		Optional<Appointment> appoint=Optional.ofNullable(appointRepo.findById(appointmentId).orElseThrow(supplier));
		return appoint.get();
	}
	
	@Override
	public List<Appointment> viewAppointments(Date date) {
		// TODO Auto-generated method stub
	return appointRepo.getByDate(date);
	}

	@Override
	public Appointment updateAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return appointRepo.saveAndFlush(appointment);
	}
}
