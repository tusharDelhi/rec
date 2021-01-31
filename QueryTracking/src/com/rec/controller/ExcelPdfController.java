package com.rec.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rec.dao.Admin_DiscomDao;
import com.rec.service.Admin_DiscomService;

@Controller
public class ExcelPdfController {
	
	@Autowired
	SessionFactory sf;
	
	
	@Autowired
	Admin_DiscomService adminDiscomService;
	
	private static Logger logger = Logger.getLogger(ExcelPdfController.class);
	
	@RequestMapping(value = "/excel",method = RequestMethod.GET)
	public ModelAndView generateExcel() throws Exception
	{
	
		logger.info("******************Generate Excel**********************"); 
		
			Session session= sf.openSession();
			List<Object[]> queryData = adminDiscomService.searchAll();
			
		
		
		return new ModelAndView("QueryExcelView","AdminPanel",queryData);
		
	
	}

}
