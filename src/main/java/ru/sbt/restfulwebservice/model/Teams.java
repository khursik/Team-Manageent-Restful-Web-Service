package ru.sbt.restfulwebservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Teams")
public class Teams {

    private int id;
    private String name;
    private String members;

    public Teams() {}

    public Teams(String name, String members) {
        this.name = name;
        this.members = members;
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

    @Column(name = "members")
    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Teams{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", members='" + members + '\'' +
                '}';
    }
}
