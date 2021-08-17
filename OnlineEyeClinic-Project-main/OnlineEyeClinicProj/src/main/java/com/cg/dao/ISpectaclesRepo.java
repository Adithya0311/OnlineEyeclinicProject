package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.Spectacles;

@Repository
public interface ISpectaclesRepo extends JpaRepository<Spectacles, Integer> {

}
