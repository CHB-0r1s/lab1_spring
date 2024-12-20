package com.example.lab1.controllers;


import com.example.lab1.repositories.AddressRepository;
import com.example.lab1.dtos.Address;
import com.example.lab1.orms.AddressORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AddressController {
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/address/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable Long id) {
        Optional<AddressORM> optionalAddressORM = addressRepository.findById(id);

        if (optionalAddressORM.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new Address(optionalAddressORM.get()));
    }

    @PostMapping("/address")
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        System.out.println(address.toString());
        addressRepository.save(new AddressORM(address));

        return ResponseEntity.status(HttpStatus.CREATED).body(address);
    }

//    @PatchMapping("/address")
//    public ResponseEntity<Address> updateAddress(@RequestBody Address address) {
//        System.out.println(address.toString());
//        addressRepository.updateAddressORM(new AddressORM(address));
//
//        return ResponseEntity.status(HttpStatus.OK).body(address);
//    }
}
