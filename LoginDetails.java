package com.rec.model;

import java.io.Serializable;
import java.util.Set;

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

@Entity
@Table(name="loginDetails")
public class LoginDetails implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public LoginDetails() {
		
	}
	/**
	 * 
	 */
	
	
	
	
 
@OneToOne(cascade = CascadeType.ALL)
   private Discom discom;
   
   
	public Discom getDiscom() {
		return discom;
	}

	public void setDiscom(Discom discom) {
		this.discom = discom;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="UserId")
	private int userId;
	
	@Override
	public String toString() {
		return "LoginDetails [discom=" + discom + ", userId=" + userId + ", password=" + password + ", userName="
				+ userName + "]";
	}

    @Column
	private String password;
	
    @Column
	private String userName;
	
	
	
	


	public int getUserId() {
		return userId;
	}


   public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	
	 	
	
	

}
