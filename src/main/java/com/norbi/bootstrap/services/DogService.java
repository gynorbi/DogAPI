package com.norbi.bootstrap.services;

import com.norbi.bootstrap.entities.Dog;
import com.norbi.bootstrap.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogService {

    DogRepository repository;

    @Autowired
    public void setRepository(DogRepository repository) {
        this.repository = repository;
    }

    public List<Dog> getAll(){ return (List<Dog>)repository.findAll(); }
    public List<String> dogBreed(){
        return repository.findAllBreed();
    }

    public String dogBreedById(Long id){
        Optional<String> optionalBreed = Optional.ofNullable(repository.findBreedById(id));
        return optionalBreed.orElseThrow(DogNotFoundException::new);
    }

    public List<String> dogIdAndNames(){
        return repository.findAllName();
    }

    public Dog getDogById(Long id) {
        return repository.findById(id).orElseThrow(DogNotFoundException::new);
    }
}
