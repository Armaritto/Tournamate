package com.generator.tournamate.services;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import com.generator.tournamate.entities.LogIn;
import com.generator.tournamate.entities.SignUp;

public interface UserServiceIF {
	public String signUp (SignUp signup);
	public String logIn (LogIn login);
	public void AddSwissTournament(String username , String id , String tourname) ;
	public void AddRoundRobinTournament(String username , String id , String tourname) ;
	public ArrayList<String[]> getSwissTournaments(String username);
	public ArrayList<String[]> getRoundRobinTournament(String username);
	public String editUserName(String username, String newUserName);
	public String editPassword(String username, String oldpass, String newpass);
	public String setProfilePicture(String username, MultipartFile file);
	public byte[] getProfilePicture(String username);
}
