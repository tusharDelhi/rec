@SuppressWarnings("unused")
	@RequestMapping("/processLogin")
	public String processCredentials(@RequestParam("username") String userName, @RequestParam("password") String password,
			Model model, HttpSession session) throws IOException {
		// RedirectView view1 = new RedirectView();
		try
		{
		String message = "";
		List<LoginDetails> isValid1 = (List<LoginDetails>) admin_DiscomDao.CheckUser(userName, password);
		log.info("is user valid?=" + isValid1.toString());
		
        if (isValid1 != null)
		{
			for (LoginDetails isValid : isValid1) {
				session.setAttribute("userName", isValid.getUserName());
				System.out.println(isValid.getUserName());
				System.out.println(isValid.getPassword());
				
			//System.out.println(dis);
                session.setAttribute("state", isValid.getDiscom().getState());
                session.setAttribute("discom", isValid.getDiscom().getDiscomName());
				return "redirect:/discom";
			}
		} else {
			List<Admin> isValid2 = (List<Admin>) admin_DiscomDao.findUser(userName, password);
			log.info("is user valid?=" + isValid2.toString());

			if (isValid2 != null)

			{
				for (Admin isValid3 : isValid2) {
					session.setAttribute("username", isValid3.getUsername());
				    session.setAttribute("state", isValid3.getDiscom().getState());
	                session.setAttribute("discom", isValid3.getDiscom().getDiscomName());

					return "redirect:/admin";
						
		}
		}				message = "Invalid credentials";
			
		}
		}
        
        
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "redirect:/showMainForm";
	}
