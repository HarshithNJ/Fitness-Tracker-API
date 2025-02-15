package org.fitness.fitness_tracker.dto;


import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double duration;
    private int caloriesBurned;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String date;

    
    
}
