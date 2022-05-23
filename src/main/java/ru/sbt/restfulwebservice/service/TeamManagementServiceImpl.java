package ru.sbt.restfulwebservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sbt.restfulwebservice.exception.ResourceNotFoundException;
import ru.sbt.restfulwebservice.model.Employee;
import ru.sbt.restfulwebservice.model.Teams;
import ru.sbt.restfulwebservice.model.TeamsEmployee;
import ru.sbt.restfulwebservice.repository.EmployeeRepository;
import ru.sbt.restfulwebservice.repository.TeamsEmployeeRepository;
import ru.sbt.restfulwebservice.repository.TeamsRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamManagementServiceImpl implements TeamManagementService {

    private final TeamsEmployeeRepository teamsEmployeeRepository;
    private final EmployeeRepository employeeRepository;
    private final TeamsRepository teamsRepository;

    public TeamManagementServiceImpl(TeamsEmployeeRepository teamsEmployeeRepository, EmployeeRepository employeeRepository, TeamsRepository teamsRepository) {
        this.teamsEmployeeRepository = teamsEmployeeRepository;
        this.employeeRepository = employeeRepository;
        this.teamsRepository = teamsRepository;
    }

    @Override
    public List<Employee> findTeamMembersById(Integer teamId) throws ResourceNotFoundException {
        List<Employee> employeesList = new ArrayList<>();
        List<TeamsEmployee> employees_id = teamsEmployeeRepository.getEmployeeIdByTeam(teamId);
        for (TeamsEmployee employee_id : employees_id) {
            Employee employee = employeeRepository.findById(employee_id.getEmployee_id()).orElseThrow(
                    () -> new ResourceNotFoundException("Employee not found for this id :: " + employee_id.getEmployee_id()));
            employeesList.add(employee);
        }
        return employeesList;
    }

    @Override
    public void createTeamInDB(Teams team) {
        teamsRepository.save(team);
    }

    @Override
    public void createEmployeeInDB(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void addEmployeeToTeamInDB(TeamsEmployee teamsEmployee) {
        teamsEmployeeRepository.save(teamsEmployee);
    }
}
