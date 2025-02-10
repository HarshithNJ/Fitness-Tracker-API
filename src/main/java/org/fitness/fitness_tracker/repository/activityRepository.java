package org.fitness.fitness_tracker.repository;

import java.time.LocalDate;

import org.fitness.fitness_tracker.dto.activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface activityRepository extends JpaRepository<activity, Long> {

    boolean existsByName(String name);

    boolean existsByDate(LocalDate date);

}
