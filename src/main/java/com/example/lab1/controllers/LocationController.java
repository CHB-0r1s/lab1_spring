package com.example.lab1.controllers;

import com.example.lab1.repositories.LocationRepository;
import com.example.lab1.dtos.LocationDTO;
import com.example.lab1.orms.LocationORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LocationController {
    @Autowired
    private LocationRepository locationRepository;

    @GetMapping("/location/{id}")
    public ResponseEntity<LocationDTO> getLocation(@PathVariable Long id) {
        Optional<LocationORM> optionalLocationORM = locationRepository.findById(id);

        if (optionalLocationORM.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new LocationDTO(optionalLocationORM.get()));
    }

    @PostMapping("/location")
    public ResponseEntity<LocationDTO> createLocation(@RequestBody LocationDTO locationDTO) {
        System.out.println(locationDTO.toString());
        locationRepository.save(new LocationORM(locationDTO));

        return ResponseEntity.status(HttpStatus.CREATED).body(locationDTO);
    }
}