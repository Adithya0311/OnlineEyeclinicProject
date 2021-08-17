package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Exceptions.AdminIdNotFoundException;
import com.cg.Exceptions.UserNameAlreadyExistException;
import com.cg.dao.IAdminRepo;
import com.cg.model.Admin;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminRepo adminRepo;

	@Override
	public Admin addAdmin(Admin admin) throws UserNameAlreadyExistException {
		// TODO Auto-generated method stub
		List<Admin> admins=this.viewAllAdmins();
		for(Admin ad:admins)
		{
			if(ad.getAdminUserName().equals(admin.getAdminUserName()))
			{
				throw new UserNameAlreadyExistException("username already exist.....Please modify your username !");
			}
		}
		return adminRepo.saveAndFlush(admin);
	}

	@Override
	public List<String> getAdmins() {
		// TODO Auto-generated method stub
		List<String> usernameList=new ArrayList<String>();
		List<Admin> adminList=adminRepo.findAll();
		for(Admin admin:adminList)
		{
			usernameList.add(admin.getAdminUserName());
		}
		return usernameList;
	}

	@Override
	public List<Admin> viewAllAdmins() {
		// TODO Auto-generated method stub
		return adminRepo.findAll();
	}

	@Override
	public Admin removeAdmin(int adminId) throws AdminIdNotFoundException {
		// TODO Auto-generated method stub
		Supplier<AdminIdNotFoundException> supplier=()->new AdminIdNotFoundException("no admin found with this id");
	  Optional<Admin> a=Optional.ofNullable(adminRepo.findById(adminId).orElseThrow(supplier));
	  adminRepo.deleteById(adminId);
	  return a.get();
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepo.saveAndFlush(admin);
	}

	@Override
	public Admin viewAdmin(int adminId) throws AdminIdNotFoundException {
		// TODO Auto-generated method stub
		Supplier<AdminIdNotFoundException> supplier=()->new AdminIdNotFoundException("no admin found with this id");
		Optional<Admin> a=Optional.ofNullable(adminRepo.findById(adminId).orElseThrow(supplier));
		  return a.get();
	}
}
