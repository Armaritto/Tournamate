package com.RoundRobin.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Table(name = "Teams")
@Entity
public class RoundRobinTeam extends Participant{
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   @Column(name = "Rank")
   public int teamRank = 0;
   @Column(name = "Loss")
   private int Loss = 0;
   @Column(name = "Win")
   private int Win = 0;
   @Column(name = "Draw")
   private int Draw = 0;

   public RoundRobinTeam() {
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
              '}';
   }
}
