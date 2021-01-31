@RequestMapping(value="/searchBar",method = RequestMethod.GET)
	public String SearchForm(HttpServletRequest req,Model model) throws ParseException
	{
		String state = req.getParameter("keyword");
		String search = req.getParameter("search");
		String queryRegistered1=req.getParameter("queryRegistered");
		String queryCompliance1=req.getParameter("queryCompliance");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date queryRegistered=sdf.parse(queryRegistered1);
		Date queryCompliance=sdf.parse(queryCompliance1);
		System.out.println(search);
		System.out.println("hi");

		List<Object[]> searchList=null;
		if(search.equalsIgnoreCase("state")) {
		 searchList = 	adminService.searchbar(state, queryRegistered, queryCompliance);
		}else if(search.equalsIgnoreCase("discom"))
		{
	 searchList = 	adminService.searchbar2(state, queryRegistered, queryCompliance);
		}
		System.out.println(searchList.toString());
		model.addAttribute("search1", searchList);
		//model.addAttribute("search",search)
		return "Admin";
	}