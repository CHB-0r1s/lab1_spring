package com.example.lab1.orms;

import com.example.lab1.dtos.LocationDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Entity
@Table(name = "locations")
public class LocationORM {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "x", nullable = false)
    private Double x;

    @Column(name = "y")
    private Double y;

    @Column(name = "z")
    private Integer z;

    @Column(name = "name")
    private String name;

    public LocationORM() {}

    public LocationORM(Double x, Double y, Integer z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public LocationORM(@org.jetbrains.annotations.NotNull LocationDTO locationDTO) {
        this.id = locationDTO.getId();
        this.x = locationDTO.getX();
        this.y = locationDTO.getY();
        this.z = locationDTO.getZ();
        this.name = locationDTO.getName();
    }

    @OneToMany(mappedBy = "town")
    private List<AddressORM> addresses;

}