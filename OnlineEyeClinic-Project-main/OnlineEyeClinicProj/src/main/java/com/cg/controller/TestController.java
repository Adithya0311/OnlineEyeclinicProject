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
import com.cg.Exceptions.TestIdNotFoundException;
import com.cg.model.Appointment;
import com.cg.model.Test;
import com.cg.service.ITestService;

@RestController
@RequestMapping("test/api/v1")
public class TestController {

	@Autowired
	private ITestService ts;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/tests")
	public ResponseEntity<List<Test>> getAllTests(){
		List<Test> test= ts.viewAllTests();
		if(test.isEmpty()) {
			return new ResponseEntity("Sorry! tests not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Test>>(test, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/tests")
	public ResponseEntity<Test> InsertTest(@RequestBody Test tests){
		Test test= ts.addTest(tests);
		if(test==null) {
			return new ResponseEntity("Sorry! tests not inserted!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Test>(test, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @DeleteMapping("/tests/{testId}")
	public ResponseEntity<Test> deleteTest(
			@PathVariable("testId")Integer testId)throws TestIdNotFoundException{
		Test tests= ts.removeTest(testId);
		if(tests==null) {
			return new ResponseEntity("Sorry! tests not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Test>(tests, HttpStatus.OK);
	}
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping("/tests/{testId}")
	public ResponseEntity<Test> findTest(
			@PathVariable("testId")Integer testId)throws TestIdNotFoundException{
		Test test= ts.viewTest(testId);
		if(test==null) {
			return new ResponseEntity("Sorry! tests not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Test>(test, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @PutMapping("/tests")
	public ResponseEntity<Test> updateTest(
			 @RequestBody Test test){
		Test tests= ts.updateTest(test);
		if(tests==null)
		{
			return new ResponseEntity("Sorry! test not updated!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Test>(tests, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getTests/{doctorId}")
	public ResponseEntity<List<Test>> viewTests(@PathVariable("doctorId")Integer doctorId)throws DoctorIdNotFoundException{
		List<Test> doc=ts.viewTestsByDoctor(doctorId);
		if(doc.isEmpty()) {
			return new ResponseEntity("Sorry! tests not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Test>>(doc, HttpStatus.OK);
	}
    
}
