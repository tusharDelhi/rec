package com.rec.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.rec.dao.Admin_DiscomDao;
import com.rec.dao.LoginDao;
import com.rec.model.Admin;
import com.rec.model.Discom;
import com.rec.model.LoginDetails;

@Controller

public class HomeController {
	@Autowired
	private LoginDao loginDao;

	@Autowired
	Admin_DiscomDao admin_DiscomDao;
	private static Logger log = Logger.getLogger(HomeController.class);
	LoginDetails loginDetails = new LoginDetails();

	@RequestMapping(path = "/showMainForm", method = RequestMethod.GET)
	public String Home() {
		log.info("Home Controller");
		log.info("Launching Login page");

		System.out.println("Most welcome to home Controller");

		// model.addAttribute("user", user);
		return "Home";

	}
	
	@RequestMapping("/adminSignIn")
	public String showAdmin()
	{
		log.info("Admin Login Form");
		return "AdminLogin";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(HttpServletRequest req, HttpServletResponse ressponse, HttpSession session, Model model)
			throws IOException {
		model.addAttribute("userId", session.getAttribute("username"));
		// model.addAttribute("usertype",session.getAttribute("usertype"));
		return "Admin";
	}

	@RequestMapping(value = "/discom", method = RequestMethod.GET)
	public String discom(HttpServletRequest req, HttpServletResponse ressponse, HttpSession session, Model model)
			throws IOException {
		model.addAttribute("discom", new Discom());
		model.addAttribute("userId", session.getAttribute("username"));
		// model.addAttribute("usertype",session.getAttribute("usertype"));
		model.addAttribute("adddiscom", new Discom());
		return "Discom-user-page";
	}

	@RequestMapping("/processLogin")
	public String processCredentials(@RequestParam("userName") String userName, @RequestParam("password") String password,
			Model model, HttpSession session) throws IOException {
		// RedirectView view1 = new RedirectView();
		String message = "";
		List<LoginDetails> isValid1 = (List<LoginDetails>) loginDao.findUser(userName, password);
		log.info("is user valid?=" + isValid1);

		if (isValid1 != null)

		{
			for (LoginDetails isValid : isValid1) {
				session.setAttribute("username", isValid.getUserName());
                session.setAttribute("state", isValid.getDiscom().getState());
                session.setAttribute("discom", isValid.getDiscom().getDiscomName());
				return "redirect:/discom";
			}
		} else {
			message = "Invalid credentials";

		}

		return "redirect:/showMainForm";
	}

	@RequestMapping("/processLogin1")
	public String processAdminCredentials(@RequestParam("username") String  userName,
			@RequestParam("Password") String password, Model model, HttpSession session) throws IOException {
		// RedirectView view1 = new RedirectView();
		String message = "";
		List<Admin> isValid1 = (List<Admin>) admin_DiscomDao.findUser(userName, password);
		log.info("is user valid?=" + isValid1);

		if (isValid1 != null)

		{
			for (Admin isValid : isValid1) {
				session.setAttribute("username", isValid.getUsername());

				return "redirect:/admin";
			}
		} else {
			message = "Invalid credentials";

		}

		return "redirect:/showMainForm";
	}
}