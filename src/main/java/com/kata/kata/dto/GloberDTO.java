package com.kata.kata.dto;

import com.kata.kata.model.Glober;
import com.kata.kata.model.Position;
import com.kata.kata.model.Seniority;

public record GloberDTO(String email, String name, String positionName, String SeniorityDescription) {
    public static GloberDTO fromEntity(Glober glober) {
        return new GloberDTO(glober.getGloberEmail(), glober.getGloberName(), glober.getPosition().getPositionName(), glober.getSeniority().getSeniorityDescription());
    }
}
