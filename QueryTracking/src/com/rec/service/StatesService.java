package com.rec.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rec.dao.StatesDao;
import com.rec.model.StateDiscom;
import com.rec.model.States;

@Service
public class StatesService {
	
	@Autowired
	private StatesDao statesDao;
	private static Logger log = Logger.getLogger(StatesService.class);
	public List<States> findAllStates()
	{
		return statesDao.findAllStates();
	}
	
	public States find(int id)
	{
		return  statesDao.find(id);
	}
	
	
	
}
