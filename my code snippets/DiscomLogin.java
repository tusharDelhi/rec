public List<LoginDetails>  CheckUser(String userName,String password)    //method to authentic user on the basis of user type
	{
	//	LoginDetails loginDetails = new LoginDetails();
		
		//log.info("Inside the Login Dao class \t"+LoginDao.class);
		
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