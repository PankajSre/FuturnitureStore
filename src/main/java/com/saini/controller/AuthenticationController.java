package com.saini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.saini.model.ContactUs;
import com.saini.model.User_Authentication;
import com.saini.model.User_Authorization;
import com.saini.service.ContactUsService;
import com.saini.service.User_AuthenticationService;
import com.saini.service.User_AuthorizationService;

@Controller
public class AuthenticationController {

	@Autowired
	private User_AuthenticationService service;
  
	@Autowired
	private ContactUsService contactService;
	
	@RequestMapping("/signUp")
	
	   public String signUpPage() {
	      return "signUpPage";
	   }
	@ModelAttribute("instuser")
	public User_Authentication authentication()
	{
		return new User_Authentication();
	}
	@RequestMapping("/adduser")
	public String addNewProduct(@ModelAttribute("instuser") User_Authentication user , BindingResult result)
	{
	   
	   service.addUser(user);
	   User_Authorization roleAuth=new User_Authorization();
	   roleAuth.setRole("ROLE_USER");
	   roleAuth.setUserid(user.getUserid());
	   
	   service.addRole(roleAuth);
		return "loginPage";
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contactPage() {
		
		
		return new ModelAndView("contactPage");
	}

	@ModelAttribute("contact")
	public ContactUs contact()
	{
		return new ContactUs();
	}
	@RequestMapping("/addContact")
	public String addContact(@ModelAttribute("contact") ContactUs contact , BindingResult result)
	{
		contactService.contactUs(contact);
	
		return "contactPage";
		
	}
}
