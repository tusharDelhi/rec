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
@Table(name="Discom",schema = "rec2")
public class Discom  implements Serializable {
	
	
	
    
	
	public Discom(  int queryNo, String state, String discomName, String userName,
			String facility, String queryDescription) {
		super();
		
		this.queryNo = queryNo;
		this.State = state;
		this.discomName = discomName;
		this.userName = userName;
		this.facility = facility;
		this.queryDescription = queryDescription;
	}

	

		public Discom(int queryNo, String userName, String facility, String queryDescription, Date queryRegistered) {
		super();
		this.queryNo = queryNo;
		this.userName = userName;
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

	public Discom( int userId, int queryNo, String state, String discomName, String userName,
			String facility, String queryDescription, Date queryRegistered) {
		super();
		
		this.userId = userId;
		this.queryNo = queryNo;
		State = state;
		this.discomName = discomName;
		this.userName = userName;
		this.facility = facility;
		this.queryDescription = queryDescription;
		this.queryRegistered = queryRegistered;
	}

	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int userId;
	
	@Column
	private int queryNo;
	
	@Column
	private String State;
	
	@Column
	private String discomName;
	
	@Column
	private String userName;
	
	
	@Column
	private String facility;
	
	@Column
	private String queryDescription;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date queryRegistered;

	@Override
	public String toString() {
		return "Discom [userId=" + userId + ", queryNo=" + queryNo + ", State=" + State + ", discomName=" + discomName
				+ ", userName=" + userName + ", facility=" + facility + ", queryDescription=" + queryDescription
				+ ", queryRegistered=" + queryRegistered + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getQueryNo() {
		return queryNo;
	}

	public void setQueryNo(int queryNo) {
		this.queryNo = queryNo;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getDiscomName() {
		return discomName;
	}

	public void setDiscomName(String discomName) {
		this.discomName = discomName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
