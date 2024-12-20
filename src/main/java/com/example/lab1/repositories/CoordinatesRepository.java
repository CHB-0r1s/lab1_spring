package com.example.lab1.repositories;

import com.example.lab1.orms.CoordinatesORM;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CoordinatesRepository extends CrudRepository<CoordinatesORM, Long> {
    CoordinatesORM findById(long id);
}
