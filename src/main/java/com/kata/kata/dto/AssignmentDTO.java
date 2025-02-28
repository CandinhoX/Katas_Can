package com.kata.kata.dto;

import com.kata.kata.model.Assignment;

import java.time.LocalDate;

public record AssignmentDTO(GloberDTO glober, LocalDate from, LocalDate to, Integer percentage) {
    public static AssignmentDTO fromEntity(Assignment assignment) {
        return new AssignmentDTO(
                GloberDTO.fromEntity(assignment.getGlober()),
                assignment.getDateFrom(),
                assignment.getDateTo(),
                assignment.getPercentage()
        );
    }
}
