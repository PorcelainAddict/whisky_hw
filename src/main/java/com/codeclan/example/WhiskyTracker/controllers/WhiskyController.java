package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping
    public ResponseEntity getByAge(
            @RequestParam(required = false, name = "age") Integer age
    ){
        if (age != null){
            return new ResponseEntity(whiskyRepository.findAllWhiskiesByAge(age), HttpStatus.OK);
        }
        return new ResponseEntity(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/distilleries")
    public ResponseEntity getWhiskyByDistilleryAndAge(
            @RequestParam(required = false, name = "distillery") String name,
            @RequestParam(required = false, name = "age") Integer age
    ){
        if (name != null && age != null){
            return new ResponseEntity(whiskyRepository.findWhiskyByDistilleryAndAge(name, age), HttpStatus.OK);
        }
        return new ResponseEntity(whiskyRepository.findAll(), HttpStatus.OK);
    }

}
