package ru.sbt.restfulwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import ru.sbt.restfulwebservice.model.TeamsEmployee;

import java.util.List;

@Repository
public interface TeamsEmployeeRepository extends JpaRepository<TeamsEmployee, Integer> {
    @Query("select t from TeamsEmployee t where t.team_id = ?1")
    List<TeamsEmployee> getEmployeeIdByTeam(int team_id);
}
