package com.example.lab1.dtos;
import com.example.lab1.orms.AddressORM;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @NotNull(message = "Id Address не может быть null")
    private Long id;

    @Size(max = 190)
    private String street; //Длина строки не должна быть больше 190, Поле может быть null

    private LocationDTO town; //Поле может быть null

    public Address(AddressORM addressORM) {
        this.street = addressORM.getStreet();
        this.town = new LocationDTO(addressORM.getTown());
    }
}
