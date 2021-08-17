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

import com.cg.Exceptions.AdminIdNotFoundException;
import com.cg.Exceptions.UserNameAlreadyExistException;
import com.cg.model.Admin;
import com.cg.model.Test;
import com.cg.service.IAdminService;

@RestController
@RequestMapping("admin/api/v1")
public class AdminController {

	@Autowired
	private IAdminService as;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/get")
	public ResponseEntity<List<Admin>> getAllAdmins(){
		List<Admin> admins= as.viewAllAdmins();
		if(admins.isEmpty()) {
			return new ResponseEntity("Sorry! admins not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Admin>>(admins, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/insert")
	public ResponseEntity<Admin> InsertAdmin(@RequestBody Admin admin) throws UserNameAlreadyExistException{
	 Admin admins= as.addAdmin(admin);
		if(admins==null) {
			return new ResponseEntity("Sorry! admin not inserted!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Admin>(admins, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @DeleteMapping("/delete/{adminId}")
	public ResponseEntity<Admin> deleteAdmin (
			@PathVariable("adminId")Integer adminId)throws  AdminIdNotFoundException{
		Admin admin=as.removeAdmin(adminId);
		if(admin==null) {
			return new ResponseEntity("Sorry! admin not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping("/viewAdmin/{adminId}")
	public ResponseEntity<Admin> findAdmin(
			@PathVariable("adminId")Integer adminId)throws AdminIdNotFoundException{
		Admin admin=as.viewAdmin(adminId);
		if(admin==null) {
			return new ResponseEntity("Sorry! admin not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @PutMapping("/update")
	public ResponseEntity<Admin> updateAdmin(
			 @RequestBody Admin admin){
    	Admin admins=as.updateAdmin(admin);
		if(admins==null)
		{
			return new ResponseEntity("Sorry! admin not updated!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Admin>(admins, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping("/getAdminUserNames")
	public ResponseEntity<List<String>> getAllUsernames()
	{
    	List<String> admins= as.getAdmins();
		if(admins.isEmpty()) {
			return new ResponseEntity("Sorry! tests not found!", 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<String>>(admins,HttpStatus.OK);
	}
}
