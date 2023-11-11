package com.generator.tournamate.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generator.tournamate.RoundNotFoundException;
import com.generator.tournamate.entities.KnockoutMatch;
import com.generator.tournamate.entities.KnockoutPlayer;
import com.generator.tournamate.entities.KnockoutTournament;
import com.generator.tournamate.entities.SwissPlayer;
import com.generator.tournamate.entities.SwissTournament;
import com.generator.tournamate.services.KnockoutTournamentService;

@RestController
@RequestMapping(path= "/knockout")
public class KnockoutController {
	KnockoutTournamentService knockoutTournamentService= new KnockoutTournamentService(); 
	List<KnockoutPlayer> knockoutPlayerList =List.of(new KnockoutPlayer("player0"),
            new KnockoutPlayer( "player1"),
            new KnockoutPlayer( "player2"),
            new KnockoutPlayer("player3")
         );
	KnockoutTournament myKnockoutTournament = null;
	
    @PostMapping(path= "/newKnockoutTournament")
    public KnockoutTournament generateTournament(@RequestBody String name) throws RoundNotFoundException {
    	myKnockoutTournament = knockoutTournamentService.startNewTournament(name, knockoutPlayerList);
        System.out.println(myKnockoutTournament);
        return myKnockoutTournament;
    }
    
    @PutMapping(path= "/updateScores")
    public void updateScores(@RequestBody int[] scores) {
    	int k=0;
    	for(int i=0; i<scores.length; i+=2) {
    		myKnockoutTournament.getCurrentRound().getRoundMatches().get(k).setScore(scores[i], scores[i+1]);
    		k++;
    	}
    }
    
    @GetMapping(path= "/getTournament")
    public KnockoutTournament getTournament() {
    	return myKnockoutTournament;
    }
    
    @DeleteMapping(path= "/deleteTournament")
    public void deleteTournament() {
    	myKnockoutTournament= null;
    	System.out.print("Deleted Succesfully");
    }
    
    @PutMapping(path= "/proceedToNextRound")
    public void nextRound(){
    	knockoutTournamentService.proceedToNextRound(myKnockoutTournament);
    	System.out.print("Proceeded Succesfully");
    }
}
