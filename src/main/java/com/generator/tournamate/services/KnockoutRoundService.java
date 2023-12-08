package com.generator.tournamate.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.generator.tournamate.entities.KnockoutMatch;
import com.generator.tournamate.entities.KnockoutPlayer;
import com.generator.tournamate.entities.KnockoutRound;

public class KnockoutRoundService {
	
	public KnockoutRound generateKnockoutRound(List<KnockoutPlayer> players, int currentRound) {
		List<KnockoutPlayer> eligiblePlayers= new ArrayList<>();
		List<KnockoutMatch> matches= new ArrayList<>();
		for(KnockoutPlayer p: players) {
			if (p.hasProceeded()) {
				eligiblePlayers.add(p);
			}
		}
		for(int i=0; i<eligiblePlayers.size(); i+=2) {
			KnockoutMatch newMatch= new KnockoutMatch(eligiblePlayers.get(i), eligiblePlayers.get(i+1));
			newMatch.setScore(0, 0);
			matches.add(newMatch);
		}
		
		return new KnockoutRound(currentRound, eligiblePlayers, matches);
	}

}
