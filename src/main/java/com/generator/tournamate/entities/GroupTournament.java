package com.generator.tournamate.entities;

import java.util.Deque;
import java.util.List;

public class GroupTournament {
    Long id;
    String name;
    int numberOfGroups;
    List<RoundRobin> subTournaments;
    List<String> teams;

    public GroupTournament(Long id, String name, int numberOfGroups, List<RoundRobin> subTournaments, List<String> teams) {
        this.id = id;
        this.name = name;
        this.numberOfGroups = numberOfGroups;
        this.subTournaments = subTournaments;
        this.teams = teams;
    }

    public GroupTournament(String name, int numberOfGroups, List<RoundRobin> subTournaments, List<String> teams) {
        this.name = name;
        this.numberOfGroups = numberOfGroups;
        this.subTournaments = subTournaments;
        this.teams = teams;
    }

    public GroupTournament(String name, int numberOfGroups, List<String> teams) {
        this.name = name;
        this.numberOfGroups = numberOfGroups;
        this.teams = teams;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfGroups() {
        return numberOfGroups;
    }

    public void setNumberOfGroups(int numberOfGroups) {
        this.numberOfGroups = numberOfGroups;
    }

    public List<RoundRobin> getSubTournaments() {
        return subTournaments;
    }

    public void setSubTournaments(List<RoundRobin> subTournaments) {
        this.subTournaments = subTournaments;
    }

    public List<String> getTeams() {
        return teams;
    }

    public void setTeams(List<String> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return "GroupTournament{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfGroups=" + numberOfGroups +
                ", subTournaments=" + subTournaments +
                ", teams=" + teams +
                '}';
    }
}
