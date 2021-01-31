package com.rec.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rec.model.Admin;
import com.rec.model.Discom;
import com.rec.service.Admin_DiscomService;

@Controller
public class ProcessController {
	private static Logger log = Logger.getLogger(ProcessController.class);

	@Autowired
	Admin_DiscomService adminService;
	
	
	

	@RequestMapping(value = "/updateQuerystatus/{queryNo}",method = {RequestMethod.GET,RequestMethod.POST} )
	public String UpdateForm(@PathVariable Integer queryNo,Model model)
	{
		
		log.info("Update Query Form");
	
		model.addAttribute("adminid", queryNo);
		return "updateQuery";
		
	}
	@RequestMapping(value = "/updateQuerystatus/updateQuery",method = {RequestMethod.GET,RequestMethod.POST} )
	public String UpdateForm1(HttpServletRequest req,Model model,HttpServletResponse res) throws IOException
	{
	 String status=	req.getParameter("status");
	 String remarks  = req.getParameter("remarks");
	 String adminid=req.getParameter("adminid");
	 
		log.info("Update Query Form");
		Admin admin=adminService.getAdminId(Integer.valueOf(adminid));
		admin.setStatus(status);
		admin.setRemarks(remarks);
		//admin.setRemarks(facility);
	    adminService.saveAdminDetails(admin);
	    //res.sendRedirect("/admin");
		return "updateQuery";		
	}
	
	
/*	@RequestMapping(value="/searchBar",method = RequestMethod.GET)
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
	 */
	
	
	
	@RequestMapping(value = "/showDiscom", method = RequestMethod.GET)
	public String newFormm(Model model) {
		
        
		return "Discom-user-page";

	}
	
	
//fo m ;input   //bro just run and check o
	@RequestMapping(path = "/registerQuery", method = RequestMethod.POST)
	public String registerQery(HttpServletRequest request,HttpSession session1,Model model) {
		
		
	Integer	 query =adminService.getMaxQueryId();
			
		//queryNo =;
		try {  Discom discom = new Discom();
		
			//form page data ++request.egtparamerter 
			//usko discom.set ()
			//from page se nahi a raha h  session retrive karo
			//			
		
		
		   
			String facility = request.getParameter("facility");
			String queryDesc = request.getParameter("queryDescription");   
		    Date queryRegistered = new Date();
		 //   Discom discom=new Discom();
		    String username=(String) session1.getAttribute("userName");
		    log.info(username);
		    discom.setUsername(username);
		    String state =  (String) session1.getAttribute("state");
		    log.info(state);
		    discom.setState(state);
		    String discomname = (String) session1.getAttribute("discom");
		    log.info(discomname);
		    discom.setDiscomName(discomname);
		    discom.setFacility(facility);
		    discom.setQueryDescription(queryDesc);
		    discom.setQueryNo(query+1);
		    discom.setQueryRegistered(queryRegistered);
		    adminService.saveDiscomDetails(discom);
		    System.out.println(adminService.getMaxQueryId());
			log.info("Query id:"+query);
			
		    
            log.info("-----*---------*--------");
            log.info("Facility:"+facility);
            log.info("-----*---------*--------");
		    log.info("Query description:"+queryDesc);
		    log.info("-----*---------*--------");
			log.info("Query has been registered"+queryRegistered);
			log.info(discom);
			}

		catch (Exception e) {
			log.info("exception" + e.getMessage());
			// TODO: handle exception
		}
		return "redirect:/discom";

	}
	
	public String showQueries(Model model)
	{
	
		return "Discom-user-page";
		
	}

}
