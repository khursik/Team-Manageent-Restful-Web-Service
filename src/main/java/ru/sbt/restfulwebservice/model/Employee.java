package ru.sbt.restfulwebservice.model;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {

    private int id;
    private String name;
    private String role;
    private String position;

    public Employee() {}

    public Employee(String name, String role, String position) {
        this.name = name;
        this.role = role;
        this.position = position;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
