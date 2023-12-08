package com.generator.tournamate.entities;

public class KnockoutPlayer extends Participant{

	private boolean proceedToNextRound;
	
	public KnockoutPlayer(String name) {
		super(name);
		proceedToNextRound= true;
	}
	
	public KnockoutPlayer(String name, int score) {
		super(name, score);
		proceedToNextRound= true;
	}
	
	public KnockoutPlayer(long id, String name, int score, String photoPath) {
		super(id, name, score, photoPath);
		proceedToNextRound= true;
	}
	
	public void hasWon() {
		this.proceedToNextRound= true;
	}
	
	public void hasLost() {
		this.proceedToNextRound= false;
	}
	
	public boolean hasProceeded() {
		return this.proceedToNextRound;
	}

	@Override
	public String toString() {
		return "KnockoutPlayer [proceedToNextRound=" + proceedToNextRound + ", id=" + id + ", name=" + name + ", score="
				+ score + ", photoPath=" + photoPath + "]";
	}

}
