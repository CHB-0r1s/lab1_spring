package com.example.lab1.repositories;

import com.example.lab1.orms.AddressORM;
import com.example.lab1.orms.ProductORM;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductORM, Long> {

    ProductORM findById(long id);

    ProductORM findByName(String name);
}

