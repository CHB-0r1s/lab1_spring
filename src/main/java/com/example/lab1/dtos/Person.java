package com.example.lab1.dtos;

import com.example.lab1.orms.PersonORM;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.lab1.enums.Color;
import com.example.lab1.enums.Country;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @NotNull(message = "Id Person не может быть null")
    private Long id;

    @NotNull(message = "Имя не может быть null")
    @Size(min = 1, message = "Имя не может быть пустым")
    private String name; // Поле не может быть null, строка не может быть пустой

    private Color eyeColor; // Поле может быть null

    @NotNull(message = "Цвет волос не может быть null")
    private Color hairColor; // Поле не может быть null

    private LocationDTO locationDTO; // Поле может быть null

    @Positive(message = "Рост должен быть больше 0")
    private Integer height; // Поле может быть null, значение поля должно быть больше 0

    @NotNull(message = "Гражданство не может быть null")
    private Country nationality; // Поле не может быть null

    public Person(PersonORM personORM) {
        this.id = personORM.getId();
        this.name = personORM.getName();
        this.eyeColor = personORM.getEyeColor();
        this.hairColor = personORM.getHairColor();
        this.locationDTO = new LocationDTO(personORM.getLocation());
        this.height = personORM.getHeight();
        this.nationality = personORM.getNationality();

    }
}