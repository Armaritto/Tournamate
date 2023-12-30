package com.generator.tournamate.services;
import org.springframework.beans.factory.annotation.Autowired;

import com.generator.tournamate.entities.Database;
import com.generator.tournamate.entities.LogIn;
import com.generator.tournamate.entities.Profile;
import com.generator.tournamate.entities.SignUp;
import com.generator.tournamate.entities.User;
import com.generator.tournamate.repository.UserRepository;

import jakarta.activation.MimetypesFileTypeMap;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

@Service
public class UserService implements UserServiceIF {
	@Autowired
	private UserRepository userRepository;


public String signUp (SignUp signup)
{
		//check validity of email address
		if(!isValidEmail(signup.getEmail())) return "Invalid email address.";

		//check if someone username and email is available
		User user = userRepository.findByUsername(signup.getUsername());
		if(user!=null) return "Username is already taken.";
	     user =userRepository.findByEmail(signup.getEmail());
		if(user!=null) return "Email is already taken.";

		else {
			user =new User();
			//check if password equals password cofirmation
			if(!signup.getPassword().equals(signup.getPassConfirm()))return "Those passwords didn't match.";

			//check if length of username is valid
			if(signup.getUsername().length()<6) return "Use 6 characters or more username.";
			else if (signup.getUsername().length()>32) return "Too long username.";

			//check if length of first Name is valid
			if(signup.getFirstname().length()<2) return "Too short last name.";
			else if (signup.getFirstname().length()>32) return "Too long first name.";

			//check if length of last Name is valid
			if(signup.getLastname().length()<2) return "Too short last name.";
			else if (signup.getFirstname().length()>32) return "Too long last name.";

			//check if length of password is valid
			if(signup.getPassword().length()<8)return "Use 8 characters or more password.";
			else if (signup.getPassword().length()>64) return "Too long password.";

			//check if username is valid or not
			if(signup.getUsername().contains(" "))
				return "Username cannot contain spaces.";

			user.setEmail(signup.getEmail());
			user.setPassword(signup.getPassword());
			user.setUsername(signup.getUsername());
			user.setFirstname(signup.getFirstname());
			user.setLastname(signup.getLastname());
            this.NewProfile(signup);

			userRepository.save(user);
			return "signUpSuccess";
		}
}

public String logIn (LogIn login)
{

		if(login.getUsernameOrEmail().length()==0){
			return "Enter valid Username/Email.";
		}
		if(login.getPassword().length()==0){
			return "Enter valid Password.";
		}
		Database d = Database.getInstance();
	    Profile p = d.getProfile(login.getUsernameOrEmail());
		if(p==null) {
			return "Invalid Username.";
		}
		else
			if(login.getPassword().equals(p.getPassword()))
			return "loginSuccess";
			else return "Wrong Password";
}

public static boolean isValidEmail(String email)
{
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
}
public void NewProfile(SignUp sign) {
	Database data = Database.getInstance();
	data.addProfile(new Profile(sign.getFirstname(),sign.getLastname()
			,sign.getUsername(),sign.getPassword(),sign.getEmail()));
}
public void AddSwissTournament(String username , String id , String tourname) {
	Database d = Database.getInstance();
	Profile p = d.getProfile(username);
	String[] s = {tourname,id};
	 p.getSwissTournaments().add(s);
}
public void AddRoundRobinTournament(String username , String id , String tourname) {
	Database d = Database.getInstance();
	Profile p = d.getProfile(username);
	String[] s = {tourname,id};
    p.getRoundRobinTournaments().add(s);
}
public ArrayList<String[]> getSwissTournaments(String username){
	Database d = Database.getInstance();
	Profile p = d.getProfile(username);
	return p.getSwissTournaments();
}
public ArrayList<String[]> getRoundRobinTournament( String username){
	Database d = Database.getInstance();
	Profile p = d.getProfile(username);
	return p.getRoundRobinTournaments();
}
public String editUserName(String username , String newUserName)
{
	Database d = Database.getInstance();
	Profile p = d.getProfile(username);
	Profile p2 = d.getProfile(newUserName);
	if(p2!=null) return "Username is already taken";
	if(newUserName.length()>=6 && newUserName.length()<=32)
	{
		p.setUsername(newUserName);
		return "UserNamesuccess";
	}
	if(newUserName.length()<6)
	return"Too Short Username";
	else if(newUserName.length()>32)
		return"Too Long Username";
    return "UserNamesuccess";
}
public String editPassword(String username ,String oldpass , String newpass)
{
	System.out.println("I AM HEREEEEEEEEEEEEEEEEEEEEEEEEEE"+oldpass);
	Database d = Database.getInstance();
	Profile p = d.getProfile(username);
	if(!p.getPassword().equals(oldpass))
		return "Wrong Password";
	if(newpass.length()<8)
		return "Too Short Password";
	else if(newpass.length()>64)
		return "Too Long Password";
	p.setPassword(newpass);
	return "passwordsuccess";
}
public String setProfilePicture( String username,
		 MultipartFile file) {
	Database d = Database.getInstance();
	Profile p = d.getProfile(username);
	if (!isPicture(file)) {
        return "Invalid file format. Only images are allowed.";
    }
	try {
		p.setImage(file.getBytes());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "PictureSuccess";
}
public static boolean isPicture(MultipartFile file) {
    MimetypesFileTypeMap fileTypeMap = new MimetypesFileTypeMap();
	 String contentType = fileTypeMap.getContentType(file.getOriginalFilename());
	return contentType != null && contentType.startsWith("image");
}
public byte[] getProfilePicture(String username) {
	Database d = Database.getInstance();
	Profile p = d.getProfile(username);
	return p.getImage();

}


}
