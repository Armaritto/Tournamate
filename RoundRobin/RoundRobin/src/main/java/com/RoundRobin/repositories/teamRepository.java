package com.RoundRobin.repositories;

import com.RoundRobin.entities.RoundRobinTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface teamRepository extends JpaRepository<RoundRobinTeam,Integer> {
    public RoundRobinTeam findByTeamName(String Name);

}
