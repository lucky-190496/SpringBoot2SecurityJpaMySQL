package com.name.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.name.model.User;
import com.name.service.IUserService;

@Controller
public class UserController {
	@Autowired
	private IUserService servie;
	
	/**
	 * Show Register Page at browser
	 * when we enter /register URL, that
	 * @return UI page UserRegister.html
	 */
	@GetMapping("/register")
	public String showReg() {
		return "UserRegister";
	}
	/**
	 * This method takes 2 inputs
	 * @param user (model class object as ModelAttribute)
	 * @param model memory to send data to UI and 
	 * @return UI page name after saving User data in DB table
	 */
	
	@PostMapping("/save")
	public String saveUser(
			@ModelAttribute User user,
			Model model)
	{
		Integer id = servie.saveUser(user);
		String message = "User '"+id+"' saved";
		model.addAttribute("message", message);
		return "UserRegister";
		
	}
	
	/**
	 * 3. This method is used to display Login page
	 *    when enduser enter /login with GET type
	 */
	@GetMapping("/login")
	public String showLogin() {
		return "UserLogin";
	}
	
	
	
	
	
	
	
}