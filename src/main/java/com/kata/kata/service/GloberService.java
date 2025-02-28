package com.kata.kata.service;

import com.kata.kata.dto.AssignmentDTO;
import com.kata.kata.dto.GloberDTO;
import com.kata.kata.dto.GloberInfoDTO;
import com.kata.kata.model.Assignment;
import com.kata.kata.model.Glober;
import com.kata.kata.repository.AssignmentRepository;
import com.kata.kata.repository.GloberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GloberService {
    private final GloberRepository globerRepository;
    private final AssignmentRepository assignmentRepository;

    public GloberService(GloberRepository globerRepository, AssignmentRepository assignmentRepository) {
        this.globerRepository = globerRepository;
        this.assignmentRepository = assignmentRepository;
    }

    public List<GloberDTO> getGlobersByStudio(Integer studioId) {
        return globerRepository.findByStudioId(studioId).stream()
                .map(GloberDTO::fromEntity)
                .toList();
    }

    public GloberInfoDTO getGloberInfo(Integer globerId) {
        Glober glober = globerRepository.findById(globerId)
                .orElseThrow(() -> new RuntimeException("Glober not found"));
        List<Assignment> assignments = assignmentRepository.findByGloberId(globerId);
        LocalDate now = LocalDate.now();

        List<AssignmentDTO> current = new ArrayList<>();
        List<AssignmentDTO> history = new ArrayList<>();

        for (Assignment assignment : assignments) {
            AssignmentDTO dto = AssignmentDTO.fromEntity(assignment);
            if (assignment.getDateTo() == null || assignment.getDateTo().isAfter(now)) {
                current.add(dto);
            } else {
                history.add(dto);
            }
        }

        return GloberInfoDTO.fromEntity(glober, current, history);
    }
}
