package com.example.lab1.dtos;

import com.example.lab1.orms.ProductORM;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.lab1.enums.UnitOfMeasure;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @NotNull(message = "Id Product не может быть null")
    private Long id;

    @NotNull(message = "Название продукта не может быть null")
    @Size(min = 1, message = "Название продукта не может быть пустым")
    private String name; // Поле не может быть null, строка не может быть пустой

    @NotNull(message = "Координаты не могут быть null")
    private Coordinates coordinates; // Поле не может быть null

    @NotNull(message = "Дата создания не может быть null")
    private Date creationDate; // Поле не может быть null, значение должно генерироваться автоматически

    @NotNull(message = "Единица измерения не может быть null")
    private UnitOfMeasure unitOfMeasure; // Поле не может быть null

    @NotNull(message = "Производитель не может быть null")
    private Organization manufacturer; // Поле не может быть null

    @Positive(message = "Цена должна быть больше 0")
    private Float price; // Поле может быть null, значение поля должно быть больше 0

    private Long manufactureCost; // Поле может быть null

    @Positive(message = "Рейтинг должен быть больше 0")
    private Long rating; // Поле может быть null, значение поля должно быть больше 0

    @Size(max = 55, message = "Номер детали не должен превышать 55 символов")
    private String partNumber; // Строка не может быть пустой, длина строки не должна быть больше 55, уникальность должна обрабатываться в базе данных, поле может быть null

    @NotNull(message = "Владелец не может быть null")
    private Person owner; // Поле не может быть null

    public Product(ProductORM productORM) {
        this.id = productORM.getId();
        this.name = productORM.getName();
        this.coordinates = new Coordinates(productORM.getCoordinates());
        this.creationDate = productORM.getCreationDate();
        this.unitOfMeasure = productORM.getUnitOfMeasure();
        this.manufacturer = new Organization(productORM.getManufacturer());
        this.price = productORM.getPrice();
        this.manufactureCost = productORM.getManufactureCost();
        this.rating = productORM.getRating();
        this.partNumber = productORM.getPartNumber();
        this.owner = new Person(productORM.getOwner());
    }
}

