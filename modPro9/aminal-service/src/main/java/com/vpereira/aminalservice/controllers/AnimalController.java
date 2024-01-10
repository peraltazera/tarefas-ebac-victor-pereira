package com.vpereira.aminalservice.controllers;

import com.vpereira.aminalservice.entities.Animal;
import com.vpereira.aminalservice.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    private AnimalRepository repository;

    @GetMapping
    private List<Animal> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{type}")
    private List<Animal> findByType(@PathVariable String type){
        return repository.findByType(type);
    }

    @PostMapping()
    private Animal addAnimal(@RequestBody Animal animal){
        return repository.save(animal);
    }

    @GetMapping("/{type}/not-adopted")
    private List<Animal> findNotAdopted(@PathVariable String type){
        return repository.findNotAdopted(type);
    }

    @GetMapping("/{type}/adopted")
    private List<Animal> findAdopted(@PathVariable String type){
        return repository.findAdopted(type);
    }

    @GetMapping("/resgate")
    private List<Object[]> countResgate(){
        return repository.countResgate();
    }
}
