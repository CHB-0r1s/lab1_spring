package com.example.lab1.controllers;

import com.example.lab1.dtos.Coordinates;
import com.example.lab1.orms.CoordinatesORM;
import com.example.lab1.repositories.CoordinatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CoordinatesController {
    @Autowired
    private CoordinatesRepository coordinatesRepository;

    @GetMapping("/coordinates/{id}")
    public ResponseEntity<Coordinates> getCoordinates(@PathVariable Long id) {
        Optional<CoordinatesORM> optionalCoordinatesORM = coordinatesRepository.findById(id);

        if (optionalCoordinatesORM.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new Coordinates(optionalCoordinatesORM.get()));
    }

    @PostMapping("/coordinates")
    public ResponseEntity<Coordinates> createAddress(@RequestBody Coordinates coordinates) {
        System.out.println(coordinates.toString());
        coordinatesRepository.save(new CoordinatesORM(coordinates));

        return ResponseEntity.status(HttpStatus.CREATED).body(coordinates);
    }
}