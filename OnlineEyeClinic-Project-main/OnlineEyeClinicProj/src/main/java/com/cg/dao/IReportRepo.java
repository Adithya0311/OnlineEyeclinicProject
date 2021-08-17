package com.cg.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.model.Report;

@Repository
public interface IReportRepo extends JpaRepository<Report,Integer> {
	@Query("from Report where dateOfReport=?1")
	public List<Report> findReportsByDate(Date date);
	@Query("from Report where patient.patientId=?1")
	public List<Report> findReportByPatient(int patientId);
	
	
}
