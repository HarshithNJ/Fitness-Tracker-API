package org.fitness.fitness_tracker.controller;

import org.fitness.fitness_tracker.dto.activity;
import org.fitness.fitness_tracker.service.activityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class activityController {
    
    @Autowired
    activityService service;

    // To Add a activity
    @PostMapping("/activities")
    public ResponseEntity<Object> addActivity(@RequestBody activity activity){
        return service.addActivity(activity);
    }






    // To Fetch a activity
    @GetMapping("/activities")
    public ResponseEntity<Object> getActivity(){
        return service.getActivity();
    }
}