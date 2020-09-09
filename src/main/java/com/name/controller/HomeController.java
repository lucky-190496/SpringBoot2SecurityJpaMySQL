package com.name.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.name.model.User;
import com.name.service.IUserService;

@Controller
/***
 * Declare attributes what you want to store.
 */
@SessionAttributes({"title","dte","fmt"})
public class HomeController {
	@Autowired
	private IUserService service;

	@GetMapping("/emp")
	public String showEmp() {
		return "EmployeePage";
	}
	
	@GetMapping("/admin")
	public String showAdmin() {
		return "AdminPage";
	}
	
	@GetMapping("/common")
	public String showCommon(Model model,Principal p) {
		System.out.println(p.getClass().getName());
		//adding data to attribute
		User ob=service.getUserByEmail(p.getName());
		model.addAttribute("title", ob);
		//model.addAttribute("title", p.getName());
		return "CommonPage";
	}

	@GetMapping("/denied")
	public String showDenied() {
		return "DeniedPage";
	}
	
	
}
