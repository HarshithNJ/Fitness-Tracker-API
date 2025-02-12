package org.fitness.fitness_tracker.controller;

import org.fitness.fitness_tracker.dto.activity;
import org.fitness.fitness_tracker.service.activityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Activity Controller", description = "Activity Controller API")
public class activityController {
    
    @Autowired
    activityService service;

    // To Add a activity
    @PostMapping("/activities")
    @Operation(summary = "Add a activity", description = "Adds a activity to the Database")
    @ApiResponse(responseCode = "201", description = "Activity Added Successfully")
    @ApiResponse(responseCode = "400", description = "Activity Already Exists")
    @ApiResponse(responseCode = "406", description = "Enter the Valid Value for the Calories Burned")
    public ResponseEntity<Object> addActivity(@RequestBody activity activity){
        return service.addActivity(activity);
    }






    // To Fetch a activity
    @GetMapping("/activities")
    @Operation(summary = "Get all activities", description = "Retrieves all activities from the Database")
    @ApiResponse(responseCode = "302", description = "Activities Retrieved Successfully")
    @ApiResponse(responseCode = "404", description = "Activities Not Found")
    public ResponseEntity<Object> getActivity(){
        return service.getActivity();
    }

    @GetMapping("/activities/{name}")
    @Operation(summary = "Get a activity by name", description = "Retrieves a activity by name from the Database")
    @ApiResponse(responseCode = "302", description = "Activity Retrieved Successfully")
    @ApiResponse(responseCode = "404", description = "Activity Not Found")
    public ResponseEntity<Object> getActivityByName(@PathVariable String name){
        return service.getActivityByName(name);
    }

    @GetMapping("/activities/date/{date}")
    @Operation(summary = "Get a activity by date", description = "Retrieves a activity by date from the Database")
    @ApiResponse(responseCode = "302", description = "Activity Retrieved Successfully")
    @ApiResponse(responseCode = "404", description = "Activity Not Found")
    public ResponseEntity<Object> getActivityByDate(@PathVariable String date){
        return service.getActivityByDate(date);
    }






    // To Delete a activity
    @DeleteMapping("/activities/{id}")
    @Operation(summary = "Delete a activity", description = "Removes a activity from the Database")
    @ApiResponse(responseCode = "200", description = "Activity Deleted Successfully")
    @ApiResponse(responseCode = "404", description = "Activity Not Found")
    public ResponseEntity<Object> deleteActivity(@PathVariable Long id){
        return service.deleteActivity(id);
    }
    
    @DeleteMapping("/activities")
    @Operation(summary = "Delete all activities", description = "Removes all activities from the Database")
    @ApiResponse(responseCode = "200", description = "Activities Deleted Successfully")
    @ApiResponse(responseCode = "404", description = "Activities Not Found")
    public ResponseEntity<Object> deleteAllActivity(){
        return service.deleteAllActivity();
    }
}