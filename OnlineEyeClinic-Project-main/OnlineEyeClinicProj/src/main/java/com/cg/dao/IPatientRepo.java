package com.cg.dao;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.Patient;

@Repository
public interface IPatientRepo extends JpaRepository<Patient,Integer> {

}
