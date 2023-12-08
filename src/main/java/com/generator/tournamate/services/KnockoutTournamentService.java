package com.generator.tournamate.services;

import java.util.ArrayList;
import java.util.List;

import com.generator.tournamate.entities.KnockoutMatch;
import com.generator.tournamate.entities.KnockoutPlayer;
import com.generator.tournamate.entities.KnockoutTournament;

public class KnockoutTournamentService {
	KnockoutRoundService roundService= new KnockoutRoundService();
	public KnockoutTournament startNewTournament(String name, List<KnockoutPlayer> players) {
		KnockoutTournament tournament= new KnockoutTournament(name, players);
		tournament.addRound(roundService.generateKnockoutRound(players, tournament.getCurrentRoundNumber()));
		while(tournament.getCurrentRoundNumber() <= tournament.getTotalNumberOfRounds()) {
			if(tournament.getCurrentRound().isRoundFinished()) {
				tournament.addRound(roundService.generateKnockoutRound(players, tournament.getCurrentRoundNumber()));
			}
		}
		return tournament;
	}
	
    public void proceedToNextRound(KnockoutTournament myKnockoutTournament) {
    	List<KnockoutMatch> matches= myKnockoutTournament.getCurrentRound().getRoundMatches();
    	for(int i=0; i<matches.size(); i++) {
    		matches.get(i).setWinner();
    	}
		List<KnockoutPlayer> qualified= new ArrayList<>();
		for(KnockoutPlayer p: myKnockoutTournament.getCurrentRound().getCurrentPlayers()) {
			if (p.hasProceeded()) {
				KnockoutPlayer qualP= new KnockoutPlayer(p.getName());
				qualified.add(qualP);
			}
		}
		myKnockoutTournament.getCurrentRound().fnishRound();
		myKnockoutTournament.addRound(roundService.generateKnockoutRound(qualified, myKnockoutTournament.getCurrentRoundNumber()));
    }
}