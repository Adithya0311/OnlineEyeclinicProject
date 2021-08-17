package com.cg.service;

import org.springframework.stereotype.Service;

@Service
public interface ILoginService {
	//admin login
	public String adminLogin(String username,String password);
	//patient login
	public String patientLogin(String username,String password);
	//doctor login
	public String doctorLogin(String username,String password);
}
