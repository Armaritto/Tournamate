package com.RoundRobin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TournamentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TournamentApplication.class, args);
	}

}
