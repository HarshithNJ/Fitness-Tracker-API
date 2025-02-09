package repository;

import org.fitness.fitness_tracker.dto.activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface activityRepository extends JpaRepository<activity, Long> {

}
