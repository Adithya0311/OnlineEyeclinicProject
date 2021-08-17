package com.cg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.model.Test;

@Repository
public interface ITestRepo extends JpaRepository<Test, Integer> {
	@Query("from Test where doctor.doctorId=?1")
public List<Test> getTestsByDoctor(int doctorId);
}
