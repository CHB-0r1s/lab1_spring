package com.example.lab1.controllers;

import com.example.lab1.dtos.Person;
import com.example.lab1.orms.PersonORM;
import com.example.lab1.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        Optional<PersonORM> optionalPersonORM = personRepository.findById(id);

        if (optionalPersonORM.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new Person(optionalPersonORM.get()));
    }

    @PostMapping("/person")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        System.out.println(person.toString());
        personRepository.save(new PersonORM(person));

        return ResponseEntity.status(HttpStatus.CREATED).body(person);
    }
}
