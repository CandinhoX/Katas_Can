package com.kata.kata.service;

import com.kata.kata.dto.GloberDTO;
import com.kata.kata.dto.StudioDTO;
import com.kata.kata.model.Glober;
import com.kata.kata.model.Studio;
import com.kata.kata.repository.GloberRepository;
import com.kata.kata.repository.StudioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudioService {
    private final StudioRepository studioRepository;
    private final GloberRepository globerRepository;

    public StudioService(StudioRepository studioRepository, GloberRepository globerRepository) {
        this.studioRepository = studioRepository;
        this.globerRepository = globerRepository;
    }

    public List<GloberDTO> getGlobersByStudio(Integer studioId) {
        // Verify studio exists
        if (!studioRepository.existsById(studioId)) {
            throw new RuntimeException("Studio not found with id: " + studioId);
        }

        return globerRepository.findByStudioId(studioId).stream()
                .map(this::convertToDTO)
                .toList();
    }

    private GloberDTO convertToDTO(Glober glober) {
        return new GloberDTO(
                glober.getGloberEmail(),
                glober.getGloberName(),
                glober.getPosition().getPositionName(),
                glober.getSeniority().getSeniorityDescription()
        );
    }

    public List<StudioDTO> getAllStudios() {
        return studioRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    private StudioDTO convertToDTO(Studio studio) {
        return new StudioDTO(
                studio.getId(),
                studio.getStudioName()
        );
    }
}