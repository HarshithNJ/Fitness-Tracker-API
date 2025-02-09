package org.fitness.fitness_tracker.controller;

import org.fitness.fitness_tracker.service.activityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class activityController {
    
    @Autowired
    activityService service;
}
