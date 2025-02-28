package com.kata.kata.repository;

import com.kata.kata.model.Assignment;
import com.kata.kata.model.AssignmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, AssignmentId> {

    // Existing method
    @Query("SELECT a FROM Assignment a WHERE a.project.id = :projectId AND (a.dateTo IS NULL OR a.dateTo >= CURRENT_DATE)")
    List<Assignment> findCurrentByProjectId(@Param("projectId") Integer projectId);

    // NEW: Find all assignments for a specific glober
    List<Assignment> findByGlober_Id(Integer globerId);

    // Alternative using JPQL query
    @Query("SELECT a FROM Assignment a WHERE a.glober.id = :globerId")
    List<Assignment> findByGloberId(@Param("globerId") Integer globerId);

    // Existing overlap check
    @Query("SELECT a FROM Assignment a WHERE a.glober.id = :globerId " +
            "AND ((a.dateTo IS NULL OR a.dateTo >= :startDate) " +
            "AND (a.dateFrom <= :endDate OR :endDate IS NULL))")
    List<Assignment> findOverlappingAssignments(@Param("globerId") Integer globerId,
                                                @Param("startDate") LocalDate startDate,
                                                @Param("endDate") LocalDate endDate);
}
