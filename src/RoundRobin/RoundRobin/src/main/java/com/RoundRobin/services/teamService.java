package com.RoundRobin.services;

import com.RoundRobin.entities.RoundRobinTeam;
import com.RoundRobin.repositories.teamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class teamService {
    private teamRepository teamRepo;
    private RoundRobinTeam team;
    private String name;

    public List<RoundRobinTeam>getAll()
    {
        return (List<RoundRobinTeam>) this.teamRepo.findAll();
    }
    public void update(RoundRobinTeam Team, String Name)
    {
        for (RoundRobinTeam t :getAll())
        {
            if(t.getName().equals(Name))
            {
                this.teamRepo.save(Team);
            }
        }
    }
    public void addTeam(RoundRobinTeam Team){ this.teamRepo.save(Team);}
    public void delete(RoundRobinTeam Team){this.teamRepo.delete(Team);}

    public Optional<RoundRobinTeam> getTeam(Integer id) {
        Optional<RoundRobinTeam> t =this.teamRepo.findById(id);
        return t;
    }
}
