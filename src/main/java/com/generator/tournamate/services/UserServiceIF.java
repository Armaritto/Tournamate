package com.generator.tournamate.services;

import com.generator.tournamate.entities.LogIn;
import com.generator.tournamate.entities.SignUp;

public interface UserServiceIF {
	public String signUp (SignUp signup);
	public String logIn (LogIn login);
}
