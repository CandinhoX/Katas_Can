package com.kata.kata.dto;

import com.kata.kata.model.Studio;

public record StudioDTO(
        Integer id,
        String name
) {
    public static StudioDTO fromEntity(Studio studio) {
        return new StudioDTO(
                studio.getId(),
                studio.getStudioName()
        );
    }
}
