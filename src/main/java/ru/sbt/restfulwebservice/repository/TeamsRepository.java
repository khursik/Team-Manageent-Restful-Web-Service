package ru.sbt.restfulwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sbt.restfulwebservice.model.Teams;

@Repository
public interface TeamsRepository extends JpaRepository<Teams, Integer> {

}
