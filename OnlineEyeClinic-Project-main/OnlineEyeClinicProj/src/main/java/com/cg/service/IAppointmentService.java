package com.cg.service;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.Exceptions.AppointmentIdNotFoundException;
import com.cg.model.Appointment;
import com.fasterxml.jackson.annotation.JsonFormat;

@Service
public interface IAppointmentService {
public List<Appointment> viewAllAppointments();
public Appointment bookAppointment(Appointment appoint);
public Appointment cancelAppointment(int AppointmentId)throws AppointmentIdNotFoundException;
public Appointment viewAppointment(int appointmentId)throws AppointmentIdNotFoundException;
public List<Appointment> viewAppointments(Date date);
public Appointment updateAppointment(Appointment appointment);
}
