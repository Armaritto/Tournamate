package com.generator.tournamate.entities;
import java.util.ArrayList;

public class Database {
	 private static final Database obj = new Database();
	 private ArrayList<Profile> profiles = new ArrayList<>();
	 
	 public static Database getInstance(){
	        return obj;
     }
	 
	 public void addProfile(Profile p){
		   this.profiles.add(p);
	 }
	 
	 public ArrayList<Profile> getProfiles(){
		   return profiles;
	 }

   	 public void setProfiles(ArrayList<Profile> profiles){
		   this.profiles = profiles;
	 }

	 public Profile getProfile(String username){
			for(Profile p: profiles){
				if( p.getUsername().equals(username)){	
					return p;
				}
	        }
			
			return null;
	 }
	 
	 private Database(){
	    	profiles = new ArrayList<>();
	 }
	    
	 public boolean isValid(String username){
	    	for(Profile p: profiles){
				if(p.getUsername().equals(username)){
	                return true;
				}
	        }  
	    	return false;
	 }
	public void NewProfile(SignUp sign) {
			Database data = Database.getInstance();
		        data.addProfile(new Profile(sign.getFirstname(),sign.getLastname()
					        ,sign.getUsername(),sign.getPassword(),sign.getEmail()));	
	}
}
	 