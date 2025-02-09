package org.fitness.fitness_tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.activityRepository;

@Service
public class activityService {
    
    @Autowired
    activityRepository repository;
}
