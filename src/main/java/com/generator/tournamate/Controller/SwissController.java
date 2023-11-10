package com.generator.tournamate.Controller;

import com.generator.tournamate.SwissPlayer;
import com.generator.tournamate.SwissTournament;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/swiss")
public class SwissController {

   List<SwissPlayer> swissPlayerList = Arrays.asList(new SwissPlayer(0, "player0"),
            new SwissPlayer(0, "player1"),
            new SwissPlayer(0, "player2"),
            new SwissPlayer(0, "player3"),
            new SwissPlayer(0, "player4"),
            new SwissPlayer(0, "player5"),
            new SwissPlayer(0, "player6"),
            new SwissPlayer(0, "player7"),
            new SwissPlayer(0, "player8"),
            new SwissPlayer(0, "player9"),
            new SwissPlayer(0, "player10"));
    @GetMapping
    public String generateTournament(){
        return  new SwissTournament(5, swissPlayerList).toString();

    }
}
