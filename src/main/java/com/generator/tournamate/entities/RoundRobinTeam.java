package com.generator.tournamate.entities;

public class RoundRobinTeam extends Participant{
   public int teamRank = 0;

   private int Loss = 0;

   private int Win = 0;

   private int Draw = 0;

   public RoundRobinTeam(){

   }
   public RoundRobinTeam(String name)
   {
      this.name=name;
   }

   public int getLoss() {
      return Loss;
   }

   public void setLoss(int loss) {
      Loss += loss;
   }

   public int getDraw() {
      return Draw;
   }


   public int getWin() {
      return Win;
   }

   public void setWin(int win) {
      Win = win;
      this.score+= 3;
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
              ", Loss=" + Loss +
              ", Win=" + Win +
              ", Draw=" + Draw +
              ", score=" + score +
              '}';
   }
}
