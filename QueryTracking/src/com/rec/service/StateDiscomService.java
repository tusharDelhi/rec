package com.rec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rec.dao.StateDiscomDao;
import com.rec.model.StateDiscom;

@Service
public class StateDiscomService {
	
	@Autowired
	StateDiscomDao stateDiscomDao;
	
	
	public List<StateDiscom> findByState(int id)
	{
		return stateDiscomDao.findByState(id);
	}
	
	public List<StateDiscom> findAllDiscoms()
	{
		return stateDiscomDao.findAllDiscoms();
	}
	
	
}
