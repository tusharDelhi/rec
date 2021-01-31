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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "Administrator", schema = "rec2")
public class Admin implements Serializable {

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Discom discom;

//	@Override
//	public String toString() {
//		return "Admin [discom=" + discom + ", username=" + username + ", Password=" + Password + ", remarks=" + remarks
//				+ ", adminId=" + adminId + ", status=" + status + ", queryComplianceDate=" + queryComplianceDate + "]";
//	}
	@Override
	public String toString() {
		return "Admin [ username=" + username + "]";
	}

	public Discom getDiscom() {
		return discom;
	}

	public void setDiscom(Discom discom) {
		this.discom = discom;
	}

	public Admin(String remarks, String status, Date queryComplianceDate) {
		super();
		this.remarks = remarks;
		status = status;
		this.queryComplianceDate = queryComplianceDate;
	}

	private String username;

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		status = status;
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
	private Integer adminId;

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	@Column
	private String status;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date queryComplianceDate;


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public Date getQueryComplianceDate() {
		return queryComplianceDate;
	}

	public void setQueryComplianceDate(Date queryComplianceDate) {
		this.queryComplianceDate = queryComplianceDate;
	}

}
