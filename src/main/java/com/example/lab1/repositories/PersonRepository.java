package com.example.lab1.repositories;

import com.example.lab1.orms.PersonORM;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<PersonORM, Long> {

    PersonORM findById(long id);

    PersonORM findByName(String name);
}
