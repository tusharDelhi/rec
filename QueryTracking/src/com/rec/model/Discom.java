package com.rec.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "Discom")
public class Discom implements Serializable {

	
   public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

private String priority;
	

	public Discom(String priority, Admin admin, Integer userId, int queryNo, String state, String discomName,
		String username, String facility, String queryDescription, Date queryRegistered) {
	super();
	this.priority = priority;
	this.admin = admin;
	this.userId = userId;
	this.queryNo = queryNo;
	this.state = state;
	this.discomName = discomName;
	this.username = username;
	this.facility = facility;
	this.queryDescription = queryDescription;
	this.queryRegistered = queryRegistered;
}

	public String getPriority() {
	return priority;
}

public void setPriority(String priority) {
	this.priority = priority;
}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Admin admin;

	

	public Discom(int queryNo, String userName, String facility, String queryDescription, Date queryRegistered) {
		super();
		this.queryNo = queryNo;
		this.username = userName;
		this.facility = facility;
		this.queryDescription = queryDescription;
		this.queryRegistered = queryRegistered;
	}

	public Discom(int queryNo, String facility, String queryDescription, Date queryRegistered) {
		super();
		this.queryNo = queryNo;
		this.facility = facility;
		this.queryDescription = queryDescription;
		this.queryRegistered = queryRegistered;
	}

	public Discom(String facility, String queryDescription, Date queryRegistered) {
		super();
		this.facility = facility;
		this.queryDescription = queryDescription;
		this.queryRegistered = queryRegistered;
	}

	public Discom() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer userId;

	@Column
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int queryNo;

	@Column
	private String state;

	@Column
	private String discomName;

	@Column
	private String username;

	@Column
	private String facility;

	@Column
	private String queryDescription;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date queryRegistered;

	

	public int getQueryNo() {
		return queryNo;
	}

	@Override
	public String toString() {
		return "Discom [username=" + username + "]";
	}

	public void setQueryNo(int queryNo) {
		this.queryNo = queryNo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDiscomName() {
		return discomName;
	}

	public void setDiscomName(String discomName) {
		this.discomName = discomName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	public String getQueryDescription() {
		return queryDescription;
	}

	public void setQueryDescription(String queryDescription) {
		this.queryDescription = queryDescription;
	}

	public Date getQueryRegistered() {
		return queryRegistered;
	}

	public void setQueryRegistered(Date queryRegistered) {
		this.queryRegistered = queryRegistered;
	}

}
