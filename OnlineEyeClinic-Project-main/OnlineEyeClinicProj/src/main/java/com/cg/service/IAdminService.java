package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.Exceptions.AdminIdNotFoundException;
import com.cg.Exceptions.UserNameAlreadyExistException;
import com.cg.model.Admin;

@Service
public interface IAdminService {
//add admin
public Admin addAdmin(Admin admin) throws UserNameAlreadyExistException;
//view list of admin usernames
public List<String> getAdmins();
//view all admins
public List<Admin> viewAllAdmins();
//remove admin
public Admin removeAdmin(int adminId) throws AdminIdNotFoundException;
//update admin
public Admin updateAdmin(Admin admin);
//view admin by individual id
public Admin viewAdmin(int adminId) throws AdminIdNotFoundException;
}
