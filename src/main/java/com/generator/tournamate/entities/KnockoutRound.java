package com.generator.tournamate.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KnockoutRound {
	int roundNumber;
	boolean roundFinished;
	List<KnockoutMatch> roundMatches;
	List<KnockoutPlayer> currentPlayers;
	
	public KnockoutRound() {
		this.roundFinished= false;
		this.roundMatches= new ArrayList<>();
	}
	
	public KnockoutRound(int roundNumber, List<KnockoutPlayer> currentPlayers, List<KnockoutMatch> matches) {
		this.roundNumber = roundNumber;
		this.currentPlayers = currentPlayers;
		this.roundMatches= matches;
		this.roundFinished= false;
	}

	public int getRoundNumber() {
		return roundNumber;
	}

	public void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
	}

	public boolean isRoundFinished() {
		return roundFinished;
	}

	public List<KnockoutMatch> getRoundMatches() {
		return roundMatches;
	}

	public void setRoundMatches(List<KnockoutMatch> roundMatches) {
		this.roundMatches = roundMatches;
	}

	public List<KnockoutPlayer> getCurrentPlayers() {
		return currentPlayers;
	}

	public void setCurrentPlayers(List<KnockoutPlayer> currentPlayers) {
		this.currentPlayers = currentPlayers;
	}
	
	public void fnishRound() {
		this.roundFinished = true;
	}

	@Override
	public String toString() {
		return "KnockoutRound [roundNumber=" + roundNumber + ", roundFinished=" + roundFinished + ", roundMatches="
				+ roundMatches + ", currentPlayers=" + currentPlayers + "]";
	}
	
	
	
}
