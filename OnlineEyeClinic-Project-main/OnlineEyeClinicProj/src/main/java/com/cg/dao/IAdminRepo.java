package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.Admin;

@Repository
public interface IAdminRepo extends JpaRepository<Admin,Integer> {

}
