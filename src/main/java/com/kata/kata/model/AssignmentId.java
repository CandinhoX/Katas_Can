package com.kata.kata.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class AssignmentId implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id_glober", nullable = false)
    private Integer globerId;

    @Column(name = "id_project", nullable = false)
    private Integer projectId;

    @Column(name = "date_from", nullable = false)
    private LocalDate dateFrom;

    // Required no-arg constructor
    public AssignmentId() {}

    // All-args constructor
    public AssignmentId(Integer globerId, Integer projectId, LocalDate dateFrom) {
        this.globerId = globerId;
        this.projectId = projectId;
        this.dateFrom = dateFrom;
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssignmentId that = (AssignmentId) o;
        return Objects.equals(globerId, that.globerId) &&
                Objects.equals(projectId, that.projectId) &&
                Objects.equals(dateFrom, that.dateFrom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(globerId, projectId, dateFrom);
    }
}
