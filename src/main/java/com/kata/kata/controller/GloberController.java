package com.kata.kata.controller;

import com.kata.kata.dto.GloberInfoDTO;
import com.kata.kata.service.GloberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/globers")
@RequiredArgsConstructor
public class GloberController {
    private final GloberService globerService;

    public GloberController(GloberService globerService) {
        this.globerService = globerService;
    }

    @GetMapping("/{globerId}")
    public ResponseEntity<GloberInfoDTO> getGloberInfo(@PathVariable Integer globerId) {
        return ResponseEntity.ok(globerService.getGloberInfo(globerId));
    }
}