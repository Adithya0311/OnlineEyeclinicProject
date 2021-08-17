package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.Admin;
import com.cg.model.Doctor;
import com.cg.model.Patient;

@Service
public class LoginServiceImpl implements ILoginService{

	@Autowired
	private IAdminService adminService;
	
	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	private IPatientService patientService;
	@Override
	public String adminLogin(String username, String password) {
		// TODO Auto-generated method stub
		String detail=null;
		List<Admin> admins=adminService.viewAllAdmins();
		for(Admin admin:admins)
		{
			if(admin.getAdminUserName().equals(username) && admin.getAdminPassword().equals(password))
			{
				detail="you are logged in as : "+username;
				break;
			}
			else if(admin.getAdminUserName().equals(username) && admin.getAdminPassword()!=password)
			{
				detail="username exist but password doesn't matches";
				break;
			}
			else if(admin.getAdminUserName()!=username)
			{
				detail="username not exist. Please register !!!!";
			}
		}
		return detail;
	}

	@Override
	public String patientLogin(String username, String password) {
		// TODO Auto-generated method stub
		String detail=null;
		List<Patient> patients=patientService.viewAllPatients();
		for(Patient patient:patients)
		{
			if(patient.getPatientUserName().equals(username) && patient.getPatientPassword().equals(password))
			{
				detail="you are logged in as : "+username;
				break;
			}
			else if(patient.getPatientUserName().equals(username) && patient.getPatientPassword()!=password)
			{
				detail="username exist but password doesn't matches";
				break;
				
			}
			else if(patient.getPatientUserName()!=username)
			{
				detail="username not exist. Please register !!!!";
		
			}
		}
	
		return detail;
	}

	@Override
	public String doctorLogin(String username, String password) {
		// TODO Auto-generated method stub
		String detail=null;
		List<Doctor> doctors=doctorService.viewAllDoctors();
		for(Doctor doctor:doctors)
		{
			if(doctor.getDoctorUserName().equals(username) && doctor.getDoctorPassword().equals(password))
			{
				detail="you are logged in as : "+username;
				break;
			}
			else if(doctor.getDoctorUserName().equals(username) && doctor.getDoctorPassword()!=password)
			{
				detail="username exist but password doesn't matches";
				break;
			}
			else if(doctor.getDoctorUserName()!=username)
			{
				detail="username not exist. Please register !!!!";
			}
		}
		return detail;
	}
	
}


