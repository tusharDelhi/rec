package com.rec.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "states")
public class States implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer stateId;
	private String State;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "state")
	private Set<StateDiscom> discoms = new HashSet(0);
	
	
	//private List<Discom> discom;
	public Integer getStateId() {
		return stateId;
	}
	public Set<StateDiscom> getDiscoms() {
		return discoms;
	}
	public States(String state) {
		super();
		State = state;
	}
	public void setDiscoms(Set<StateDiscom> discoms) {
		this.discoms = discoms;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public String getState() {
		return State;
	}
	public States() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setState(String state) {
		State = state;
	}
	
	public States(Integer stateId, String state) {
		super();
		this.stateId = stateId;
		State = state;
	}
	
}
