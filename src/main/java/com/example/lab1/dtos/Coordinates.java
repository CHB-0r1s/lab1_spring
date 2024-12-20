package com.example.lab1.dtos;

import com.example.lab1.orms.CoordinatesORM;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coordinates {
    @NotNull(message = "Id Coordinates не может быть null")
    private Long id;

    public Coordinates(CoordinatesORM coordinatesORM) {
        this.x = coordinatesORM.getX();
        this.y = coordinatesORM.getY();
    }

    @NotNull(message = "Поле y не может быть null")
    private Double x; //Поле не может быть null

    @NotNull(message = "Поле y не может быть null")
    @Max(value = 777, message = "Максимальное значение поля y: 777")
    private Long y; //Максимальное значение поля: 777, Поле не может быть null
}