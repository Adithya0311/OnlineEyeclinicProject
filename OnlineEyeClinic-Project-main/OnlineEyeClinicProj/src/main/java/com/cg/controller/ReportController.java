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

import com.cg.Exceptions.ReportIdNotFoundException;
import com.cg.model.Doctor;
import com.cg.model.Report;
import com.cg.model.Spectacles;
import com.cg.model.Test;
import com.cg.service.IReportService;

@RestController
@RequestMapping("/report/api/v1")
public class ReportController {

	@Autowired
	private IReportService rs;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/reports")
	public ResponseEntity<Report> InsertReport(@RequestBody Report report){
		Report reports= rs.addReport(report);
		if(reports==null) {
			return new ResponseEntity("Sorry! report not inserted!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Report>(reports, HttpStatus.OK);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/reports/{reportId}")
	public ResponseEntity<Report> findReport(@PathVariable("reportId")Integer reportId)throws ReportIdNotFoundException{
		Report report=rs.viewReport(reportId);
		if(report==null) {
			return new ResponseEntity("Sorry! report not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Report>(report, HttpStatus.OK);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getReport/{date}")
	public ResponseEntity<List<Report>> viewReports(@PathVariable("date")Date date){
		List<Report> reports=rs.viewReportsByDate(date);
		if(reports.isEmpty()) {
			return new ResponseEntity("Sorry! reports not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Report>>(reports, HttpStatus.OK);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping("/updateReport")
	public ResponseEntity<Report> updateReport(@RequestBody Report report){
		Report reports=rs.updateReport(report);
		if(reports==null) {
			return new ResponseEntity("Sorry! reports not updated!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Report>(reports, HttpStatus.OK);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/deleteReport/{reportId}")
	public ResponseEntity<Report> deleteReport(@PathVariable("reportId")Integer reportId)throws ReportIdNotFoundException{
		Report report=rs.removeReport(reportId);
		if(report==null) {
			return new ResponseEntity("Sorry! report not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Report>(report, HttpStatus.OK);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getAllSpect")
	public ResponseEntity<List<Spectacles>> getAllSpect(){
		List<Spectacles> spect= rs.viewSpectacles();
		if(spect.isEmpty()) {
			return new ResponseEntity("Sorry! spectacles not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Spectacles>>(spect, HttpStatus.OK);
	}
}
