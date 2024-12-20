package com.example.lab1.orms;

import com.example.lab1.dtos.Address;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "addresses")
public class AddressORM {
    public AddressORM(Address address) {
        this.street = address.getStreet();
        this.town = new LocationORM(address.getTown());
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "street")
    private String street;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "town_id")
    private LocationORM town;


    public AddressORM() {};

    public AddressORM(String street, LocationORM town) {
        this.street = street;
        this.town = town;
    }

}