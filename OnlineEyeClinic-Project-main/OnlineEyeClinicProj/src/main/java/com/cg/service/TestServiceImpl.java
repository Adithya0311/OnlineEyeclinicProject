package com.cg.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Exceptions.DoctorIdNotFoundException;
import com.cg.Exceptions.TestIdNotFoundException;
import com.cg.dao.ITestRepo;
import com.cg.model.Test;

@Service
public class TestServiceImpl implements ITestService{
	@Autowired
private ITestRepo testRepo;

	@Override
	public Test addTest(Test test) {
		// TODO Auto-generated method stub
		return testRepo.saveAndFlush(test);
	}

	@Override
	public Test updateTest(Test test) {
		// TODO Auto-generated method stub
		return testRepo.saveAndFlush(test);
	}

	@Override
	public Test removeTest(int testId)throws TestIdNotFoundException {
		// TODO Auto-generated method stub
		Supplier<TestIdNotFoundException> supplier=()->new TestIdNotFoundException("test with given id is not available");
		Optional<Test> t=Optional.ofNullable(testRepo.findById(testId).orElseThrow(supplier));
		testRepo.deleteById(testId);
		return t.get();
	}

	@Override
	public Test viewTest(int testId) throws TestIdNotFoundException{
		// TODO Auto-generated method stub
		Supplier<TestIdNotFoundException> supplier=()->new TestIdNotFoundException("test with given id is not available");
		Optional<Test> t=Optional.ofNullable(testRepo.findById(testId).orElseThrow(supplier));
		return t.get();
	}

	@Override
	public List<Test> viewAllTests() {
		// TODO Auto-generated method stub
		return testRepo.findAll();
	}

	@Override
	public List<Test> viewTestsByDoctor(int doctorId) throws DoctorIdNotFoundException {
		// TODO Auto-generated method stub
		return testRepo.getTestsByDoctor(doctorId);
	}
	
}
