package com.rec.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rec.model.Admin;
import com.rec.model.StateDiscom;
import com.rec.model.States;

@Repository
public class StateDiscomDao {
	//this is tha class which contains db related method
	@Autowired
	private SessionFactory sf;
	private static Logger log = Logger.getLogger(StateDiscomDao.class);
	public Integer selectedValue=0;
	@SuppressWarnings("unchecked")
	public List<StateDiscom> findByState(int id)
	{
			
      List<StateDiscom> sd = null;
      Session session = sf.openSession();
      Transaction tx = null;
      try
      {
    	  tx = session.beginTransaction();
    	  sd  = (List<StateDiscom>) session.createQuery("select s.id as id,"+"s.name as name"+" From StateDiscom"+"where state.stateId=:id").setInteger("id", id).setResultTransformer(Transformers.aliasToBean(States.class)).list();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return sd;
	}
	
	public List<StateDiscom> findAllDiscoms()
	{ 
	
		log.info("Finding All the states");
		Session session = sf.openSession();
			
			log.info("value of session"+session);
		   Query<StateDiscom> select_Discom  =session.createQuery("From StateDiscom ");
		   List<StateDiscom> discomList = select_Discom.list();
		   log.info("list of states"+discomList.toString());
		  
			
			return discomList;
			}
	
}
		
	
		
	


