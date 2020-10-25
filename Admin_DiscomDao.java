package com.rec.dao;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rec.model.Admin;
import com.rec.model.Discom;
import com.rec.model.LoginDetails;


@Repository
public class Admin_DiscomDao {
	private static Logger log= Logger.getLogger(Admin.class);
	
	@Autowired
	private SessionFactory sf;
	
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	@Transactional
	public void saveAdminDetails(Admin admin)
	{
		
		log.info("Inside the Admin_DiscomDao"+Admin_DiscomDao.class);
		log.info("Opening session");
		Discom dis = new Discom();
	    Session session = sf.openSession();
	    log.info("session opened"+session);
	    
	    admin.setQueryComplianceDate(new Date());
	   Transaction tx= session.beginTransaction();
	   log.info("session started");
	    session.save(admin);
	    log.info("Admin details has been saved");
	   tx.commit();
	   log.info("transaction  is commited"+tx);
	  
	  
	   	     		
	}
	
	
	@Transactional
	public void saveDiscomDetails(Discom dis)
	{ 
		
		Admin ad = new Admin();
			log.info("Inside the Admin_DiscomDao"+Admin_DiscomDao.class);
		log.info("Openning session");
		Session session = sf.openSession();
		
		log.info("session opened"+session);
		
		log.info("value of ad is:"+ ad);
	 
	
		
		Transaction tx = session.beginTransaction();
		session.save(dis);
		tx.commit();
	}
	
	
    public List<Discom> showQueries()
    {
    	Session ss = sf.openSession();
    	Criteria cr = ss.createCriteria(Discom.class);
    	List<Discom>queries = cr.list();
		return queries;
    	
		
    	
    }
    
    @Transactional
    public boolean updateQueries(String username,int queryId, String facility,String queryDescription,Date queryRegistered)
    {
	    Discom discom = new Discom();
    	Session ss = sf.openSession();
        String updateUser = "Update Discom set 	queryNo=:q,facility=:f,queryDescription=:qd,queryRegistered=:qd1 where userName=:un";
    	Transaction tx = ss.beginTransaction();
    	@SuppressWarnings("rawtypes")
		Query query = ss.createQuery(updateUser);
    	query.setParameter("q", queryId);
    	query.setParameter("f", facility);
    	query.setParameter("qd", queryDescription);
    	query.setParameter("qd1",queryRegistered);
    	query.setParameter("un", username);
    	int r = query.executeUpdate();
    	log.info("object updated"+r);
    	tx.commit();
    	ss.close();
    	return true;
    	}
    	
    public List<Admin>  findUser(String userName,String Password)    //method to authentic user on the basis of user type
	{
	//	LoginDetails loginDetails = new LoginDetails();
		
		log.info("Inside the Login Dao class \t"+LoginDao.class);
		
		log.info("Checking the user  in the database");
		boolean isValidUser =false;
		List<Admin> admin = null;
		String checkUser = "from Admin a where a.username=?0 and a.Password=?1";
		try
		{

			 admin = (List<Admin>) hibernateTemplate.find(checkUser, userName,Password);
		  
		}
		catch (Exception e) {
			e.printStackTrace();
			log.error("Login failed");
			// TODO: handle exception
		}
		
		return admin;
				
				
	}

    	
    
    

	public SessionFactory getSf() {
		return sf;
	}


	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	


	

}
