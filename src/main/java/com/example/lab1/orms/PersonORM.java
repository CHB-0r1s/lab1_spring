package com.example.lab1.orms;

import com.example.lab1.dtos.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.lab1.enums.Color;
import com.example.lab1.enums.Country;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persons")
public class PersonORM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotNull(message = "Имя не может быть null")
    @Size(min = 1, message = "Имя не может быть пустым")
    private String name; // Поле не может быть null, строка не может быть пустой

    @Column(name = "eye_color")
    private Color eyeColor; // Поле может быть null

    @Column(name = "hair_color", nullable = false)
    @NotNull(message = "Цвет волос не может быть null")
    private Color hairColor; // Поле не может быть null

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "location_id", nullable = false)
    private LocationORM location; // Поле может быть null


    @Column(name = "height")
    @Positive(message = "Рост должен быть больше 0")
    private Integer height; // Поле может быть null, значение поля должно быть больше 0

    @Column(name = "nationality", nullable = false)
    @NotNull(message = "Гражданство не может быть null")
    private Country nationality; // Поле не может быть null

    public PersonORM(Person person) {
        this.name = person.getName();
        this.eyeColor = person.getEyeColor();
        this.hairColor = person.getHairColor();
        this.height = person.getHeight();
        this.nationality = person.getNationality();
        this.location = new LocationORM(person.getLocationDTO());
    }
}
