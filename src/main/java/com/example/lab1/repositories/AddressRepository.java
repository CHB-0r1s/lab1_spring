package com.example.lab1.repositories;

import com.example.lab1.orms.AddressORM;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<AddressORM, Long> {

    AddressORM findById(long id);

    AddressORM findByStreet(String street);

//    @Modifying
//    @Query("update AddressORM a set a.street = ?1, a.town = ?2 where u.id = ?3")
//    void setUserInfoById(String firstname, String lastname, Integer userId);
//    void updateAddressORM(AddressORM addressORM);
}
