package com.kata.kata.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "seniorities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Seniority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String seniorityDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeniorityDescription() {
        return seniorityDescription;
    }

    public void setSeniorityDescription(String seniorityDescription) {
        this.seniorityDescription = seniorityDescription;
    }
}
