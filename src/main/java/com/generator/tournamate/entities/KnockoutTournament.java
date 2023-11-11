package com.generator.tournamate.entities;

import java.util.ArrayList;
import java.util.List;

public class KnockoutTournament {
	String tournamentName;
	int totalNumberOfRounds;
	int currentRoundNumber;
	boolean isFinished;
	KnockoutPlayer tournamentWinner;
	List<KnockoutRound> tournamentRounds;
	List<KnockoutPlayer> tournamentPlayers;
	
	public KnockoutTournament() {
		this.currentRoundNumber= 0;
		this.isFinished= false;
	}

	public KnockoutTournament(String tournamentName, List<KnockoutPlayer> tournamentPlayers) {
		this.tournamentName = tournamentName;
		this.tournamentPlayers = tournamentPlayers;
		this.totalNumberOfRounds= (int) ((int) Math.log10(tournamentPlayers.size())/Math.log10(2));
		this.currentRoundNumber= 0;
		this.tournamentRounds= new ArrayList<>();
		this.isFinished= false;
	}

	public String getTournamentName() {
		return tournamentName;
	}

	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}

	public int getCurrentRoundNumber() {
		return currentRoundNumber;
	}

	public void setCurrentRoundNumber(int currentRoundNumber) {
		this.currentRoundNumber = currentRoundNumber;
	}

	public List<KnockoutRound> getTournamentRounds() {
		return this.tournamentRounds;
	}

	public void setTournamentRounds(List<KnockoutRound> tournamentRounds) {
		this.tournamentRounds = tournamentRounds;
	}

	public List<KnockoutPlayer> getTournamentPlayers() {
		return this.tournamentPlayers;
	}

	public void setTournamentPlayers(List<KnockoutPlayer> tournamentPlayers) {
		this.tournamentPlayers = tournamentPlayers;
	}

	public int getTotalNumberOfRounds() {
		return this.totalNumberOfRounds;
	}
	
	public void addRound(KnockoutRound newRound) {
		this.tournamentRounds.add(newRound);
		this.currentRoundNumber++;
	}
	
	public KnockoutRound getCurrentRound() {
		return this.tournamentRounds.get(currentRoundNumber-1);
	}

	@Override
	public String toString() {
		return "KnockoutTournament [tournamentName=" + tournamentName + ", totalNumberOfRounds=" + totalNumberOfRounds
				+ ", currentRoundNumber=" + currentRoundNumber + ", tournamentRounds=" + tournamentRounds
				+ ", tournamentPlayers=" + tournamentPlayers + "]";
	}

	public KnockoutPlayer getTournamentWinner() {
		return tournamentWinner;
	}

	public void setTournamentWinner(KnockoutPlayer tournamentWinner) {
		this.tournamentWinner = tournamentWinner;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished() {
		this.isFinished = true;
	}
}
