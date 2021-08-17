package com.cg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.model.Appointment;
import com.cg.model.Doctor;

@Repository
public interface IDoctorRepo extends JpaRepository<Doctor, Integer> {
	
}
