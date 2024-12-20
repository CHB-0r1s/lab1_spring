package com.example.lab1.orms;

import com.example.lab1.dtos.*;
import com.example.lab1.enums.UnitOfMeasure;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class ProductORM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "ID не может быть null")
    @Positive(message = "ID должен быть больше 0")
    private Long id; // Поле не может быть null, значение поля должно быть больше 0, уникальность и автоматическая генерация должны обрабатываться в базе данных

    @Column(name = "name", nullable = false)
    @NotNull(message = "Название продукта не может быть null")
    @Size(min = 1, message = "Название продукта не может быть пустым")
    private String name; // Поле не может быть null, строка не может быть пустой

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "coordinates_id", nullable = false)
    @NotNull(message = "Координаты не могут быть null")
    private CoordinatesORM coordinates; // Поле не может быть null

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "Дата создания не может быть null")
    private Date creationDate; // Поле не может быть null, значение должно генерироваться автоматически

    @Column(name = "unit_of_measure", nullable = false)
    @NotNull(message = "Единица измерения не может быть null")
    private UnitOfMeasure unitOfMeasure; // Поле не может быть null

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "manufacturer_id", nullable = false)
    @NotNull(message = "Производитель не может быть null")
    private OrganizationORM manufacturer; // Поле не может быть null

    @Column(name = "price")
    @Positive(message = "Цена должна быть больше 0")
    private Float price; // Поле может быть null, значение поля должно быть больше 0

    @Column(name = "manufacture_cost")
    private Long manufactureCost; // Поле может быть null

    @Column(name = "rating")
    @Positive(message = "Рейтинг должен быть больше 0")
    private Long rating; // Поле может быть null, значение поля должно быть больше 0

    @Column(name = "part_number")
    @Size(max = 55, message = "Номер детали не должен превышать 55 символов")
    private String partNumber; // Строка не может быть пустой, длина строки не должна быть больше 55, уникальность должна обрабатываться в базе данных, поле может быть null

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "owner_id", nullable = false)
    @NotNull(message = "Владелец не может быть null")
    private PersonORM owner; // Поле не может быть null

    public ProductORM(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.manufacturer = new OrganizationORM(product.getManufacturer());
        this.manufactureCost = product.getManufactureCost();
        this.rating = product.getRating();
        this.partNumber = product.getPartNumber();
        this.unitOfMeasure = product.getUnitOfMeasure();
        this.coordinates = new CoordinatesORM(product.getCoordinates());
        this.creationDate = product.getCreationDate();
        this.owner = new PersonORM(product.getOwner());
    }

    public ProductORM(ProductItemDTO productItemDTO) {
        this.name = productItemDTO.getName();
        this.price = productItemDTO.getPrice();
        this.manufacturer = new OrganizationORM();
        this.manufactureCost = 0L;
        this.rating = 0L;
        this.partNumber = "";
        this.unitOfMeasure = UnitOfMeasure.KILOGRAMS;
        this.coordinates = new CoordinatesORM();
        this.creationDate = new Date();
        this.owner = new PersonORM();
    }
}
