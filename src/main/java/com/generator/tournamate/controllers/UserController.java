package com.generator.tournamate.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.MailSender;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.generator.tournamate.entities.Database;
import com.generator.tournamate.entities.LogIn;
import com.generator.tournamate.entities.Profile;
import com.generator.tournamate.entities.SignUp;
//import com.generator.tournamate.services.MailSenderIF;
//import com.generator.tournamate.services.MailSenderService;
import com.generator.tournamate.services.UserServiceIF;
@CrossOrigin
@RestController
public class UserController {
	@Autowired
	UserServiceIF userservice;
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
	@GetMapping(path ="/AddSwissTournament/{username}/{id}/{tourname}")
	public void AddSwissTournament (@PathVariable("username") String username,@PathVariable("id") String id,
			                       @PathVariable("tourname") String tourname)
	{
	    userservice.AddSwissTournament(username,id,tourname);
	}
	
	@GetMapping(path ="/AddRoundRobinTournament/{username}/{id}/{tourname}")
	public void AddRoundRobinTournament (@PathVariable("username") String username,@PathVariable("id") String id,
            @PathVariable("tourname") String tourname)
	{
		userservice.AddSwissTournament(username,id,tourname);

	}
	@GetMapping(path ="/getSwissTournament/{username}")
	public ArrayList<String[]> getSwissTournament(@PathVariable("username") String username){
		
		return userservice.getSwissTournaments(username);	
	}
	@GetMapping(path ="/getRoundRobinTournament/{username}")
	public ArrayList<String[]> getRoundRobinTournament(@PathVariable("username") String username){
		
		return userservice.getRoundRobinTournament(username);	
	}	
	@GetMapping(path="/editUsername/{username}/{newusername}")
	public String editUserName(@PathVariable("username") String username ,@PathVariable("newusername") String newUserName) {
		return userservice.editUserName(username , newUserName);
	
}
	@GetMapping(path="/editPassword/{username}/{oldpass}/{newpass}")
	public String editPassword(@PathVariable("username") String username ,@PathVariable("oldpass") String oldpass ,
			                 @PathVariable("newpass") String newpass)
	{
		return userservice.editPassword(username,oldpass,newpass);
	}
	
	@GetMapping(path="/getuser/{username}")
	public Profile editPassword(@PathVariable("username") String username)		                 
	{
		return Database.getInstance().getProfile(username);
	}

	@PostMapping("/setProfilePicture/{username}")
	public String setProfilePicture(@PathVariable("username") String username,
			@RequestParam("image") MultipartFile file) {
		return userservice.setProfilePicture(username , file);
		
	}
	@GetMapping("/getProfilePicture/{username}")
	public byte[] getProfilePicture(@PathVariable("username") String username) {
		return userservice.getProfilePicture(username );
		
	}
 

}
