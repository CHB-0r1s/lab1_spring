package com.example.lab1.dtos;

import com.example.lab1.orms.LocationORM;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO {
    @NotNull(message = "Id Location не может быть null")
    private Long id;

    public LocationDTO(LocationORM locationORM) {
        this.id = locationORM.getId();
        this.x = locationORM.getX();
        this.y = locationORM.getY();
        this.z = locationORM.getZ();
        this.name = locationORM.getName();
    }
    @NotNull(message = "Поле y не может быть null")
    private Double x; //Поле не может быть null

    @NotNull(message = "Поле y не может быть null")
    private Double y; //Поле не может быть null

    @NotNull(message = "Поле y не может быть null")
    private Integer z; //Поле не может быть null

    private String name; //Поле может быть null
}
