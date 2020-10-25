package com.rec.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rec.dao.Admin_DiscomDao;
import com.rec.model.Admin;
import com.rec.model.Discom;

@Service
public class Admin_DiscomService {

	
	@Autowired
	private Admin_DiscomDao adminDao;
	
	
	@Transactional
	public void saveAdminDetails(Admin admin)
	{
		adminDao.saveAdminDetails(admin);
	}
	
   @Transactional
   public void saveDiscomDetails(Discom dis)
   {
	   adminDao.saveDiscomDetails(dis);
   }
	
   @Transactional
   public boolean updateQueries(String username,int queryId, String facility,String queryDescription,Date queryRegistered)
   {
	   adminDao.updateQueries(username, queryId, facility, queryDescription, queryRegistered);
	return true;
	   
   }
   
   public List<Discom> showQueries()
   {
	   return adminDao.showQueries();
   }
}
