package com.generator.tournamate.entities;

import java.util.ArrayList;

public class Profile extends User{
	
	private ArrayList <String[]> swissTournaments ;
	private ArrayList <String[]> roundRobinTournaments ;
	private byte[]image;
	
	public Profile(String Firstname,String Lastname,String Username,String Password,String Email) {
		super.setEmail(Email);
		super.setFirstname(Firstname);
		super.setLastname(Lastname);
		super.setPassword(Password);
		super.setUsername(Username);
		this.swissTournaments = new ArrayList<>();
		this.roundRobinTournaments = new ArrayList<>();	
       }

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public ArrayList<String[]> getSwissTournaments() {
		return swissTournaments;
	}

	public void setSwissTournaments(ArrayList<String[]> swissTournaments) {
		this.swissTournaments = swissTournaments;
	}

	public ArrayList<String[]> getRoundRobinTournaments() {
		return roundRobinTournaments;
	}

	public void setRoundRobinTournaments(ArrayList<String[]> roundRobinTournaments) {
		this.roundRobinTournaments = roundRobinTournaments;
	}

}
