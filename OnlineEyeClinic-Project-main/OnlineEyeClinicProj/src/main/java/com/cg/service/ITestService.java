package com.cg.service;

import java.util.List;

import com.cg.Exceptions.DoctorIdNotFoundException;
import com.cg.Exceptions.TestIdNotFoundException;
import com.cg.model.Test;

public interface ITestService {
public Test addTest(Test test);
public Test updateTest(Test test);
public Test removeTest(int testId)throws TestIdNotFoundException;
public Test viewTest(int testId)throws TestIdNotFoundException;
public List<Test> viewAllTests();
public List<Test> viewTestsByDoctor(int doctorId)throws DoctorIdNotFoundException;
}
