public List<Admin> findUser(String userName, String Password) // method to authentic user on the basis of user type
	{
		// LoginDetails loginDetails = new LoginDetails();

		//log.info("Inside the Login Dao class \t" + LoginDao.class);

		log.info("Checking the user  in the database");
		boolean isValidUser = false;
		List<Admin> admin = null;
		String checkUser = "from Admin a where a.username=?0 and a.Password=?1";
		try {

			admin = (List<Admin>) hibernateTemplate.find(checkUser, userName, Password);

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Login failed");
			// TODO: handle exception
		}

		return admin;

	}