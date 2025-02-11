package org.fitness.fitness_tracker.repository;


import java.util.List;

import org.fitness.fitness_tracker.dto.activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface activityRepository extends JpaRepository<activity, Long> {

    boolean existsByName(String name);

    boolean existsByDate(String date);

    List<activity> findByName(String name);

    List<activity> findByDate(String date);


}
