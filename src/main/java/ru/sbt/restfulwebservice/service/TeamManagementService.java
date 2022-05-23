package ru.sbt.restfulwebservice.service;

import ru.sbt.restfulwebservice.exception.ResourceNotFoundException;
import ru.sbt.restfulwebservice.model.Employee;
import ru.sbt.restfulwebservice.model.Teams;
import ru.sbt.restfulwebservice.model.TeamsEmployee;

import java.util.List;

public interface TeamManagementService {

    public List<Employee> findTeamMembersById(Integer teamId) throws ResourceNotFoundException;

    public void createTeamInDB(Teams team);

    public void createEmployeeInDB(Employee employee);

    public void addEmployeeToTeamInDB(TeamsEmployee teamsEmployee);

}
