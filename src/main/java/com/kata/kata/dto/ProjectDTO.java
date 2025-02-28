package com.kata.kata.dto;

import com.kata.kata.model.Project;

public record ProjectDTO(Integer id, String code, String name) {
    public static ProjectDTO fromEntity(Project project) {
        return new ProjectDTO(project.getId(), project.getProjectCode(), project.getProjectName());
    }
}
