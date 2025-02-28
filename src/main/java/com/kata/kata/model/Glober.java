package com.kata.kata.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "globers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Glober {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String globerEmail;
    private String globerName;

    @ManyToOne
    @JoinColumn(name = "id_city")
    private City city;

    @ManyToOne
    @JoinColumn(name = "id_studio")
    private Studio studio;

    @ManyToOne
    @JoinColumn(name = "id_position")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "id_seniority")
    private Seniority seniority;

    private Integer salary;

    @OneToMany(mappedBy = "glober")
    private List<Assignment> assignments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGloberEmail() {
        return globerEmail;
    }

    public void setGloberEmail(String globerEmail) {
        this.globerEmail = globerEmail;
    }

    public String getGloberName() {
        return globerName;
    }

    public void setGloberName(String globerName) {
        this.globerName = globerName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Seniority getSeniority() {
        return seniority;
    }

    public void setSeniority(Seniority seniority) {
        this.seniority = seniority;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

}
