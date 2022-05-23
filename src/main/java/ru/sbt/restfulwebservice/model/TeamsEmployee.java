package ru.sbt.restfulwebservice.model;

import javax.persistence.*;

@Entity
@Table(name = "Teams_employee")
public class TeamsEmployee {

    private int employee_id;
    private int team_id;

    public TeamsEmployee() {}

    public TeamsEmployee(int employee_id, int team_id) {
        this.employee_id = employee_id;
        this.team_id = team_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    @Override
    public String toString() {
        return "TeamsEmployee{" +
                "employee_id=" + employee_id +
                ", team_id=" + team_id +
                '}';
    }
}
