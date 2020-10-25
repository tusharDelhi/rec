package com.rec.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.rec.model.LoginDetails;

@Repository
public class LoginDao {
	private static Logger log = Logger.getLogger(LoginDao.class);
	
	@Autowired
	HibernateTemplate hibernateTemplate;

    LoginDao()
    {
    	log.info("inside  LoginDao Constructor");
    }
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
		@SuppressWarnings({ "unchecked", "deprecation" })
		public List<LoginDetails>  findUser(String userName,String password)    //method to authentic user on the basis of user type
		{
		//	LoginDetails loginDetails = new LoginDetails();
			
			log.info("Inside the Login Dao class \t"+LoginDao.class);
			
			log.info("Checking the user  in the database");
			boolean isValidUser =false;
			List<LoginDetails> loginObj = null;
			String sqlQuery = "from LoginDetails l where l.userName=?0 and l.password=?1";
			try
			{

				 loginObj = (List<LoginDetails>) hibernateTemplate.find(sqlQuery, userName,password);
			  
			}
			catch (Exception e) {
				e.printStackTrace();
				log.error("Login failed");
				// TODO: handle exception
			}
			
			return loginObj;
					
					
		}
		
	
	
	
	
	

}
