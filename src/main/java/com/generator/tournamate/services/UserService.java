package com.generator.tournamate.services;
import org.springframework.beans.factory.annotation.Autowired;
import com.generator.tournamate.entities.LogIn;
import com.generator.tournamate.entities.SignUp;
import com.generator.tournamate.entities.User;
import com.generator.tournamate.repository.UserRepository;
import org.springframework.stereotype.Service;
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
		User user = userRepository
				            .findByUsernameOrEmail(login.getUsernameOrEmail(),
		                                          login.getUsernameOrEmail());
		if(user==null) {
			return "Invalid Username.";
		}
		else
			if(login.getPassword().equals(user.getPassword()))
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
	
}
