package com.fiba2.spring.relation.repository;


import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.fiba2.spring.relation.entity.Player;

public interface PlayerRepository extends CrudRepository <Player, Long> {
	@Query ("select p from Player p where p.team.teamId = :teamId")
	List<Player> findAllByTeamId (long teamId);

}
