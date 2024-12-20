package com.example.lab1.controllers;

import com.example.lab1.dtos.Organization;
import com.example.lab1.orms.OrganizationORM;
import com.example.lab1.repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrganizationsController {
    @Autowired
    private OrganizationRepository organizationRepository;

    @GetMapping("/organizations/{id}")
    public ResponseEntity<Organization> getOrganization(@PathVariable Long id) {
        Optional<OrganizationORM> optionalOrganizationORM = organizationRepository.findById(id);

        if (optionalOrganizationORM.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new Organization(optionalOrganizationORM.get()));
    }

    @PostMapping("/organizations")
    public ResponseEntity<Organization> createLocation(@RequestBody Organization organization) {
        System.out.println(organization.toString());
        organizationRepository.save(new OrganizationORM(organization));

        return ResponseEntity.status(HttpStatus.CREATED).body(organization);
    }

    @GetMapping("/organizations")
    public ResponseEntity<List<Organization>> getOrganizations() {
        List<OrganizationORM> optionalOrganizationORM = organizationRepository.findAll();
        List<Organization> ogrs = optionalOrganizationORM.stream().map(Organization::new).toList();

        return new ResponseEntity<>(ogrs, HttpStatus.OK);
    }

}
