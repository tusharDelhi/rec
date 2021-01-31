package com.rec.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rec.model.States;

import javassist.bytecode.stackmap.BasicBlock.Catch;

@Repository
public class StatesDao {
	private static  Logger log = Logger.getLogger(StatesDao.class);
	//
	
	@Autowired
	private SessionFactory sf;
	
	public List<States> findAllStates()
	{
		
	log.info("Finding All the states");
	Session session = sf.openSession();
	
		log.info("value of session"+session);
	   Query<States> select_States  =session.createQuery("From States");
	   List<States> stateList = select_States.list();
	   log.info("list of states"+stateList.toString());
	  System.out.println(stateList);
		
		return stateList;
		}
	
	public States find(int id)
	{

		States st = null;
		Session session =  sf.openSession();
		Transaction tx = null;
		try
		{
		tx = session.beginTransaction();
		st = (States)session.createQuery("From States"+"where id=:id").setInteger("id", id).uniqueResult();
		tx.commit();
		}
		catch (Exception e) {
			st=null;
			if(tx!=null)
			{
				tx.rollback();
			}
			
			// TODO: handle exception
		}
		return st;
	
		
		
	
		
	}
}
