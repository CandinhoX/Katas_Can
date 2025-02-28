package com.kata.kata.dto;

import com.kata.kata.model.Glober;

import java.util.List;

public record GloberInfoDTO(String email, String name, List<AssignmentDTO> currentAssignments, List<AssignmentDTO> history) {
    public static GloberInfoDTO fromEntity(Glober glober, List<AssignmentDTO> current, List<AssignmentDTO> history) {
        return new GloberInfoDTO(
                glober.getGloberEmail(),
                glober.getGloberName(),
                current,
                history
        );
    }
}