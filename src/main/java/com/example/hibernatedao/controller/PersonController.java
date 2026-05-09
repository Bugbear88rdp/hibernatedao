package com.example.hibernatedao.controller;

import com.example.hibernatedao.entity.Person;
import com.example.hibernatedao.repository.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/by-city")
    public ResponseEntity<List<Person>> getByCity(@RequestParam String city) {
        return ResponseEntity.ok(personRepository.findByCityOfLiving(city));
    }

    @GetMapping("/younger-than")
    public ResponseEntity<List<Person>> getByAgeLessThan(@RequestParam Integer age) {
        return ResponseEntity.ok(personRepository.findByAgeLessThanOrderByAgeAsc(age));
    }

    @GetMapping("/by-full-name")
    public ResponseEntity<Person> getByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return personRepository.findByNameAndSurname(name, surname)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}