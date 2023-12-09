package com.generator.tournamate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.MailSender;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.generator.tournamate.entities.LogIn;
import com.generator.tournamate.entities.SignUp;
//import com.generator.tournamate.services.MailSenderIF;
//import com.generator.tournamate.services.MailSenderService;
import com.generator.tournamate.services.UserServiceIF;
@CrossOrigin
@RestController
public class UserController {
	@Autowired
	UserServiceIF userservice;
//	public final MailSenderIF mails;
//    public UserController(MailSenderIF mm)
//    {
//    	this.mails = mm;
//    }
	@PostMapping("/signup")
    @ResponseBody
	public String signUP(@RequestBody SignUp sign )
	{
		return userservice.signUp(sign);
	}
	@PostMapping("/login")
    @ResponseBody
	public String logIn (@RequestBody LogIn login)
	{
		return userservice.logIn(login);
	}
	
//	@PostMapping("/forgotPass")
//    @ResponseBody
//	public  void ResponseEntity (@RequestBody String mail)
//	{
//		mails.sendMail(mail, "forgetpass", "hint");
//	}

}
