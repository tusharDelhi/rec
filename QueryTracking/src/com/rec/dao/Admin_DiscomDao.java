package com.rec.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
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
	private static Logger log = Logger.getLogger(Admin.class);

	@Autowired
	private SessionFactory sf;

	@Autowired
	private HibernateTemplate hibernateTemplate;
  //what hpnd.....
	
	public Admin getAdminId(Integer adminId)
	{
	   log.info("Finding the admin id");
	   Session session = sf.openSession();
	   Admin ad = session.get(Admin.class, adminId);
	   return ad;
	}
	
	
	
	
	public int getMaxQueryId()
	{
		Session session1 = sf.openSession();
       //   Query q = session1.createQuery("select max(queryNo from Discom");
       
  		Query q =	session1.createQuery("select max(queryNo) from Discom");
  			Integer queryId = (Integer) q.uniqueResult();
  			System.out.println(queryId);
		     
  			return queryId;
	
		
		
	}
	
	@SuppressWarnings({ "unused", "unchecked", "deprecation" })
	public List<LoginDetails>  CheckUser(String userName,String password)    //method to authentic user on the basis of user type
	{
	//	LoginDetails loginDetails = new LoginDetails();
		
		//log.info("Inside the Login Dao class \t"+LoginDao.class);
		
		log.info("Checking the user  in the database");
		boolean isValidUser =false;
		List<LoginDetails> loginObj = null;
		String sqlQuery = "from LoginDetails l where l.username=?0 and l.password=?1";
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

	
	//select d from discom where state =:keyword and queryregisterdate> :queryregistered date && querycomplaincedate<querycompliance date
	
/*	@SuppressWarnings("unused")
	public List<Object[]> search(String sr) {
		log.info("searching the data based on discom,state, Queryregistered and QueryCompliance");
		Session session = sf.openSession();
		String sql="select d.queryNo,d.state,d.discomName,d.userName,d.userId,d.facility,d.queryDescription,queryRegistered,a.status,a.queryComplianceDate,a.remarks,a.adminId from discom d left join administrator a on d.admin_adminId=a.adminId where d.discom like %";
		return null;
	    
	    
		
	}    */
	
	@SuppressWarnings("unchecked")
	public List<Object[]> searchbar(String state,Date queryRegistered,Date queryCompliance) {
		log.info("searching the data based on discom,state, Queryregistered and QueryCompliance");
		Session session = sf.openSession();
		String sql="select d.userId,d.state,d.discomName,d.userName,d.queryNo,d.facility,d.queryDescription,d.queryRegistered,a.status,a.queryComplianceDate,a.remarks,a.adminId from discom d left join administrator a on d.admin_adminId=a.adminId where d.state=:state and a.queryComplianceDate<=:queryCompilanceDate and  d.queryRegistered>=:queryregistered  ";
		NativeQuery<Object[]> nq = session.createNativeQuery(sql).setParameter("state",state ).setParameter("queryregistered", queryRegistered).setParameter("queryCompilanceDate", queryCompliance);
		
		List<Object[]> searchResults = nq.list();
		return searchResults;
	    
	    }
	

	
	 @SuppressWarnings("unchecked")
	public List<Object[]> searchbar2(String state,Date queryRegistered, Date queryCompliance)
	   {
		 log.info("searching the data based on discom,state, Queryregistered and QueryCompliance");
			Session session = sf.openSession();
			String sql="select d.userId,d.state,d.discomName,d.userName,d.queryNo,d.facility,d.queryDescription,d.queryRegistered,a.status,a.queryComplianceDate,a.remarks,a.adminId from discom d left join administrator a on d.admin_adminId=a.adminId where d.discomName=:state and a.queryComplianceDate<=:queryCompilanceDate and  d.queryRegistered>=:queryregistered  ";
			NativeQuery<Object[]> nq = session.createNativeQuery(sql).setParameter("state",state ).setParameter("queryregistered", queryRegistered).setParameter("queryCompilanceDate", queryCompliance);
			
			List<Object[]> searchResults = nq.list();
			return searchResults;
		    
	   }
	
	public List<Object[]> searchAll()
	   {
		Session session1 = sf.openSession();
		String showData = "select d.userId,d.state,d.discomName,d.userName,d.queryNo,d.facility,d.queryDescription,queryRegistered,a.status,a.queryComplianceDate,a.remarks,a.adminId from discom d left join administrator a on d.admin_adminId=a.adminId";
		NativeQuery<Object[]> nq = session1.createNativeQuery(showData);
		List<Object[]> queries = nq.list();
		log.info(queries);
		return queries;

		    
	   }
	
	
	
	
	@Transactional 
	public void saveAdminDetails(Admin admin) {
		Date dateQueryComplianceDate = new Date();
		admin.setQueryComplianceDate(dateQueryComplianceDate);
		log.info("queryComplianceDate"+dateQueryComplianceDate);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.update(admin);
		tx.commit();
	}

	@Transactional
	public void saveDiscomDetails(Discom dis) {
		// String discomN = dis.getDiscomName();
		// log.info(username);
		// String state = (String) req.getAttribute("state");
		// String discomName = (String)req.getAttribute("discom");
	Admin ad = new Admin();
		log.info("Inside the Admin_DiscomDao" + Admin_DiscomDao.class);
		log.info("Openning session");
		Session session = sf.openSession();

		log.info("session opened" + session);

		log.info("value of admin id is:" + ad.getAdminId());

		dis.setAdmin(ad);
		// dis.setState(state);
		// dis.setDiscomName(discomName);

		Transaction tx = session.beginTransaction();
		session.save(dis);
		tx.commit();
	}



	@SuppressWarnings("unchecked")
	public List<Object[]> showQueries(String username) {
		Session session1 = sf.openSession();
		String showData = "select d.userId,d.state,d.discomName,d.userName,d.queryNo,d.facility,d.queryDescription,queryRegistered,a.status,a.queryComplianceDate,a.remarks,a.adminId from discom d left join administrator a on d.admin_adminId=a.adminId where d.userName=:username";	
		NativeQuery<Object[]> nq = session1.createNativeQuery(showData).setParameter("username", username);
		List<Object[]> queries = nq.list();
		log.info(queries);
		return queries;

	}

	/*
	 * @Transactional public boolean updateQueries(String username, int queryId,
	 * String facility, String queryDescription, Date queryRegistered) { Discom
	 * discom = new Discom(); Session ss = sf.openSession(); String updateUser =
	 * "Update Discom set 	queryNo=:q,facility=:f,queryDescription=:qd,queryRegistered=:qd1 where userName=:un"
	 * ; Transaction tx = ss.beginTransaction();
	 * 
	 * @SuppressWarnings("rawtypes") Query query = ss.createQuery(updateUser);
	 * query.setParameter("q", queryId); query.setParameter("f", facility);
	 * query.setParameter("qd", queryDescription); query.setParameter("qd1",
	 * queryRegistered); query.setParameter("un", username); int r =
	 * query.executeUpdate(); log.info("object updated" + r); tx.commit();
	 * ss.close(); return true; }
	 */
	@SuppressWarnings({ "deprecation", "unchecked", "unused" })
	public List<Admin> findUser(String userName, String Password) // method to authentic user on the basis of user type
	{
		// LoginDetails loginDetails = new LoginDetails();

		//log.info("Inside the Login Dao class \t" + LoginDao.class);

		log.info("Checking the user  in the database");
		boolean isValidUser = false;
		List<Admin> admin = null;
		String checkUser = "from Admin a where a.username=?0 and a.password=?1";
		try {

			admin = (List<Admin>) hibernateTemplate.find(checkUser, userName, Password);

		} catch (Exception e) {
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
