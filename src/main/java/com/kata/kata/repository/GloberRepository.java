package com.kata.kata.repository;

import com.kata.kata.model.Glober;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GloberRepository extends JpaRepository<Glober, Integer> {
    List<Glober> findByStudioId(Integer studioId);
}
