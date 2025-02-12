package org.fitness.fitness_tracker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.fitness.fitness_tracker.dto.activity;
import org.fitness.fitness_tracker.repository.activityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class activityService {
    
    @Autowired
    activityRepository repository;

    public ResponseEntity<Object> addActivity(activity activity) {
        if(activity.getCaloriesBurned() <= 0){
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("error", "Enter the Valid Value for the Calories Burned");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_ACCEPTABLE);
        }else if (repository.existsByName(activity.getName()) && repository.existsByDate(activity.getDate())) {
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("error", "Activity Already Exists");

            return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
        }else{
            repository.save(activity);
            

            Map<String, Object> map = new HashMap<String,Object>();
            map.put("success", "Activity Added Successfully");
            map.put("activity", activity);

            return new ResponseEntity<Object>(map, HttpStatus.CREATED);
        }
    }











    public ResponseEntity<Object> getActivity() {
        List<activity> act = repository.findAll();

        if(act.isEmpty()){
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("error", "No Activity Found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("success", "Activity Found");
            map.put("activity", act);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> getActivityByName(String name) {
        List<activity> act = repository.findByName(name);

        if(act.isEmpty()){
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("error", "No Activity Found with Name: " + name);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("success", "Activity Found");
            map.put("activity", act);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> getActivityByDate(String date) {
        List<activity> act = repository.findByDate(date);

        if(act.isEmpty()){
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("error", "No Activity Found with Date: " + date);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("success", "Activity Found");
            map.put("activity", act);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }











    public ResponseEntity<Object> deleteActivity(Long id) {
        Optional<activity> act = repository.findById(id);

        if(act.isPresent()){
            repository.deleteById(id);

            Map<String, Object> map = new HashMap<String,Object>();
            map.put("success", "Activity Deleted Successfully");
            map.put("activity", act);

            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }else{
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("error", "Activity Not Found with ID: " + id);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
    }

    
}
