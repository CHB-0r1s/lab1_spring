package com.example.lab1.repositories;

import com.example.lab1.orms.LocationORM;

import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<LocationORM, Long> {

    LocationORM findById(long id);

    LocationORM findByName(String name);
}
