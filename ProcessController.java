package com.rec.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.rec.model.Discom;
import com.rec.service.Admin_DiscomService;

@Controller
public class ProcessController {
	private static Logger log = Logger.getLogger(ProcessController.class);

	@Autowired
	Admin_DiscomService adminService;

	@RequestMapping(value = "/showDiscom", method = RequestMethod.GET)
	public String newFormm(Model model) {
		
        
		return "Discom-user-page";

	}
//fo m ;input
	@RequestMapping(path = "/registerQuery", method = RequestMethod.POST)
	public String registerQery(HttpServletRequest request,HttpSession session1) {
		
		try {  Discom discom = new Discom();
		
			//form page data ++request.egtparamerter 
			//usko discom.set ()
			//from page se nahi a raha h  session retrive karo
			//			
			int q_id = Integer.parseInt(request.getParameter("queryNo"));
		
			String facility = request.getParameter("facility");
			String queryDesc = request.getParameter("queryDescription");   
		    Date queryRegistered = new Date();
		 //   Discom discom=new Discom();
		    String username=(String) session1.getAttribute("username");
		    discom.setUserName(username);
		    String state =  (String) session1.getAttribute("state");
		    discom.setState(state);
		    String discomname = (String) session1.getAttribute("discom");
		    discom.setDiscomName(discomname);
		    discom.setFacility(facility);
		    discom.setQueryDescription(queryDesc);
		    discom.setQueryNo(q_id);
		    discom.setQueryRegistered(queryRegistered);
			adminService.saveDiscomDetails(discom);			
			
            log.info("Query id:"+q_id);
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
		return "Discom-user-page";

	}

}
