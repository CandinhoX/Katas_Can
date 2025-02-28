package com.kata.kata.controller;

import com.kata.kata.dto.GloberDTO;
import com.kata.kata.dto.StudioDTO;
import com.kata.kata.service.StudioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/studios")
@RequiredArgsConstructor
public class StudioController {
    private final StudioService studioService;

    public StudioController(StudioService studioService) {
        this.studioService = studioService;
    }

    @GetMapping
    public ResponseEntity<List<StudioDTO>> getAllStudios() {
        return ResponseEntity.ok(studioService.getAllStudios());
    }

    @GetMapping("/{studioId}/globers")
    public ResponseEntity<List<GloberDTO>> getGlobersByStudio(@PathVariable Integer studioId) {
        return ResponseEntity.ok(studioService.getGlobersByStudio(studioId));
    }
}