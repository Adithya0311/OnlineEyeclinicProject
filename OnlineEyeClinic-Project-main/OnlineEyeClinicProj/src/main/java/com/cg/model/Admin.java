package com.cg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="admin_seq")
	@SequenceGenerator(name="admin_seq",sequenceName="admin_seq",allocationSize=1)
	@Column(name="admin_id")
int adminId;
	@Column(name="admin_user_name")
String adminUserName;
	@Column(name="admin_password")
String adminPassword;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminUserName() {
		return adminUserName;
	}
	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public Admin(int adminId, String adminUserName, String adminPassword) {
		//super();
		this.adminId = adminId;
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
	}
public Admin() {
	
}
@Override
public String toString() {
	return "Admin [adminId=" + adminId + ", adminUserName=" + adminUserName + ", adminPassword=" + adminPassword + "]";
}

}
