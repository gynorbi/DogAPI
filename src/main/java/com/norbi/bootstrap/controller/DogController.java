package com.norbi.bootstrap.controller;

import com.norbi.bootstrap.entities.Dog;
import com.norbi.bootstrap.services.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DogController {
    DogService service;

    @Autowired
    public void setService(DogService service) {
        this.service = service;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs(){
        return new ResponseEntity<List<Dog>>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/dogs/breed")
    public ResponseEntity<List<String>> getDogBreeds(){
        return new ResponseEntity<List<String>>(service.dogBreed(), HttpStatus.OK);
    }

    @GetMapping("/dogs/{id}")
    public ResponseEntity<Dog> getDogById(@PathVariable Long id){
        Dog dog = service.getDogById(id);
        return new ResponseEntity<Dog>(dog, HttpStatus.OK);
    }

    @GetMapping("/dogs/{id}/breed")
    public ResponseEntity<String> getDogBreedsById(@PathVariable Long id){
        return new ResponseEntity<>(service.dogBreedById(id), HttpStatus.OK);
    }

    @GetMapping("/dogs/name")
    public ResponseEntity<List<String>> getDogNames(){
        return new ResponseEntity<List<String>>(service.dogIdAndNames(), HttpStatus.OK);
    }
}
