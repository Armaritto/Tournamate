package com.generator.tournamate.entities;

public class RoundRobinTeam extends Participant {
   public int teamRank = 0;

   private int Losses = 0;

   private int Wins = 0;

   private int Draws = 0;

   public RoundRobinTeam() {

   }

   public RoundRobinTeam(String name) {
      this.name = name;
   }

   public int getLosses() {
      return Losses;
   }

   public void setLosses(int losses) {
      Losses = losses;
   }

   public int getWins() {
      return Wins;
   }

   public void setWins(int wins) {
      Wins = wins;
   }

   public int getDraws() {
      return Draws;
   }

   public void setDraws(int draws) {
      Draws = draws;
   }

   public void setTeamPoints(int teamPoints) {
      this.score += teamPoints;
   }

   public int getTeamRank() {
      return teamRank;
   }

   public void setTeamRank(int teamRank) {
      this.teamRank = teamRank;
   }

   @Override
   public String toString() {
      return "RoundRobinTeam{" +
              "teamRank=" + teamRank +
              ", Losses=" + Losses +
              ", Wins=" + Wins +
              ", Draws=" + Draws +
              '}';
   }
}


