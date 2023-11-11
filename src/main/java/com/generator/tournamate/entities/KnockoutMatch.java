package com.generator.tournamate.entities;

public class KnockoutMatch {
	KnockoutPlayer player1;
	KnockoutPlayer player2;
	
	public KnockoutMatch() {
	}

	public KnockoutMatch(KnockoutPlayer player1, KnockoutPlayer player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public KnockoutPlayer getPlayer1() {
		return player1;
	}

	public void setPlayer1(KnockoutPlayer player1) {
		this.player1 = player1;
	}

	public KnockoutPlayer getPlayer2() {
		return player2;
	}

	public void setPlayer2(KnockoutPlayer player2) {
		this.player2 = player2;
	}
	
	public void setScore(int p1Score, int p2Score) {
		this.player1.setScore(p1Score);
		this.player2.setScore(p2Score);
	}
	
	public void setWinner() {
		if(!(player1.score==0 && player2.score==0)) {
			if(player1.score> player2.score) {
				player1.hasWon();
				player2.hasLost();
			}else {
				player2.hasWon();
				player1.hasLost();
			}
		}
	}
		

	@Override
	public String toString() {
		return "KnockoutMatch [player1=" + player1 + ", player2=" + player2 + "]";
	}
}
