package com.rec.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Administrator",schema = "rec2")
public class Admin implements Serializable{
	

	public Admin(String remarks, String status, Date queryComplianceDate) {
		super();
		this.remarks = remarks;
		Status = status;
		this.queryComplianceDate = queryComplianceDate;
	}

	private String username;
	
	
	private String Password;


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}


public Admin(int adminId, String status, Date queryComplianceDate) {
		super();
		this.adminId = adminId;
		Status = status;
		this.queryComplianceDate = queryComplianceDate;
		
	}
  

@Column
private String remarks;

public String getRemarks() {
	return remarks;
}


public void setRemarks(String remarks) {
	this.remarks = remarks;
}


@Id
@Column
@GeneratedValue(strategy = GenerationType.AUTO)
private int adminId;

@Column
private String Status;

@Column
@Temporal(TemporalType.TIMESTAMP)
private Date queryComplianceDate;





@Override
public String toString() {
	return "Admin [username=" + username + ", Password=" + Password + ", remarks=" + remarks + ", adminId=" + adminId
			+ ", Status=" + Status + ", queryComplianceDate=" + queryComplianceDate + "]";
}


public int getAdminId() {
	return adminId;
}


public void setAdminId(int adminId) {
	this.adminId = adminId;
}


public String getStatus() {
	return Status;
}


public void setStatus(String status) {
	Status = status;
}


public Date getQueryComplianceDate() {
	return queryComplianceDate;
}


public void setQueryComplianceDate(Date queryComplianceDate) {
	this.queryComplianceDate = queryComplianceDate;
}




}
