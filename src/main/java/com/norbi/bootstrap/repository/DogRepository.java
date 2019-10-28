package com.norbi.bootstrap.repository;

import com.norbi.bootstrap.entities.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DogRepository extends CrudRepository<Dog,Long> {

    @Query("select d.breed from Dog d")
    List<String> findAllBreed();

    @Query("select d.breed from Dog d where d.id=:id")
    String findBreedById(Long id);

    @Query("select d.name from Dog d")
    List<String> findAllName();
}
