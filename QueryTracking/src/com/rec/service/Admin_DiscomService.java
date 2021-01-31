package com.rec.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	
	public int getMaxQueryId()
	{
		int queryId= adminDao.getMaxQueryId();
		return queryId;
	}
	
	
	
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
	
   public List<Object[]> searchbar(String state,Date queryRegistered, Date queryCompliance)
   {
	  return adminDao.searchbar(state, queryRegistered, queryCompliance);
   }
   
   public Admin getAdminId(int adminId)
   {
	return adminDao.getAdminId(adminId);
	   
   }
   
   public List<Object[]> searchAll()
   {
	return adminDao.searchAll();
	   
   }
   
   public List<Object[]> showQueries(String username)
   {
	   return adminDao.showQueries(username);
   }

   
public List<Object[]> searchbar2(String state, Date queryRegistered, Date queryCompliance) {
	// TODO Auto-generated method stub
	return adminDao.searchbar2(state, queryRegistered, queryCompliance);
	
	
}
}
