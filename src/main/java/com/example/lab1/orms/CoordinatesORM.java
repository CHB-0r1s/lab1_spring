package com.example.lab1.orms;

import com.example.lab1.dtos.Coordinates;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coordinates")
public class CoordinatesORM {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "x")
    @NotNull(message = "Поле y не может быть null")
    private Double x; //Поле не может быть null

    @Column(name = "y")
    @NotNull(message = "Поле y не может быть null")
    @Max(value = 777, message = "Максимальное значение поля y: 777")
    private Long y; //Максимальное значение поля: 777, Поле не может быть null

    public CoordinatesORM(Coordinates coordinates) {
        this.x = coordinates.getX();
        this.y = coordinates.getY();
    }
}