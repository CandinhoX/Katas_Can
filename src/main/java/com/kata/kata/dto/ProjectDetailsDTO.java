package com.kata.kata.dto;

import com.kata.kata.model.Project;

import java.util.List;

public record ProjectDetailsDTO(Integer id, String code, String name, List<AssignmentDTO> currentAssignments) {
    public static ProjectDetailsDTO fromEntity(Project project, List<AssignmentDTO> assignments) {
        return new ProjectDetailsDTO(project.getId(), project.getProjectCode(), project.getProjectName(), assignments);
    }
}