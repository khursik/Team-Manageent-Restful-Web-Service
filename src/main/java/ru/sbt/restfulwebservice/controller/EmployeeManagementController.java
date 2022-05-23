package ru.sbt.restfulwebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.sbt.restfulwebservice.exception.ResourceNotFoundException;
import ru.sbt.restfulwebservice.message.ResponseMessage;
import ru.sbt.restfulwebservice.model.Employee;
import ru.sbt.restfulwebservice.model.Teams;
import ru.sbt.restfulwebservice.model.TeamsEmployee;
import ru.sbt.restfulwebservice.service.TeamManagementServiceImpl;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class EmployeeManagementController {

    private final TeamManagementServiceImpl teamManagementService;

    public EmployeeManagementController(TeamManagementServiceImpl teamManagementService) {
        this.teamManagementService = teamManagementService;
    }


    @GetMapping("/getTeamMembers/{id}")
    public ResponseEntity<List<Employee>> getTeamMembersById(@PathVariable(value = "id") Integer teamId) throws ResourceNotFoundException {
        List<Employee> employeeList = teamManagementService.findTeamMembersById(teamId);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "description: Get all team members").body(employeeList);
    }

    @PostMapping("/createTeam")
    public ResponseEntity<ResponseMessage> createTeam(@Validated @RequestBody Teams team) {
        String message = null;
        try {
            teamManagementService.createTeamInDB(team);
            message = "Successfully created";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not create Team";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @PostMapping("/createEmployee")
    public ResponseEntity<ResponseMessage> createEmployee(@Validated @RequestBody Employee employee) {
        String message = null;
        try {
            teamManagementService.createEmployeeInDB(employee);
            message = "Successfully created";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not create Employee";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<ResponseMessage> addEmployeeToTeam(@Validated @RequestBody TeamsEmployee teamsEmployee) {
        String message = null;
        try {
            teamManagementService.addEmployeeToTeamInDB(teamsEmployee);
            message = "Successfully added";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not add Employee";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        }
    }

}
