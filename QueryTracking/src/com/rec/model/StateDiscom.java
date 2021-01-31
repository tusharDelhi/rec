package com.rec.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="StateDiscom")
public class StateDiscom implements Serializable {
	
	public StateDiscom() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stateId", nullable = false)
	private States state;
	public StateDiscom(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	private String name;
	
	
	public StateDiscom(Integer id, States state, String name) {
		super();
		this.id = id;
		this.state = state;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public States getState() {
		return state;
	}
	public void setState(States state) {
		this.state = state;
	}
	

}
