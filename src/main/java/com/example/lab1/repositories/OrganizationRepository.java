package com.example.lab1.repositories;

import com.example.lab1.orms.OrganizationORM;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrganizationRepository extends CrudRepository<OrganizationORM, Long> {

    OrganizationORM findById(long id);

    OrganizationORM findByName(String name);

    List<OrganizationORM> findAll();
}