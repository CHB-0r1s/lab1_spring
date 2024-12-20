package com.example.lab1.dtos;

import com.example.lab1.orms.OrganizationORM;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
    @NotNull(message = "Id Organization не может быть null")
    private Long id;

    @NotNull(message = "Название не может быть null")
    @Size(min = 1, message = "Название не может быть пустым")
    private String name; // Поле не может быть null, строка не может быть пустой

    @NotNull(message = "Официальный адрес не может быть null")
    private Address officialAddress; // Поле не может быть null

    @Positive(message = "Годовой оборот должен быть больше 0")
    private int annualTurnover; // Значение поля должно быть больше 0

    @Positive(message = "Количество сотрудников должно быть больше 0")
    private int employeesCount; // Значение поля должно быть больше 0

    private String fullName; // Поле может быть null

    @Min(value = 0, message = "Рейтинг должен быть больше или равен 0")
    private Double rating; // Поле может быть null, значение поля должно быть больше 0

    public Organization(OrganizationORM organizationORM) {
        this.id = organizationORM.getId();
        this.name = organizationORM.getName();
        this.officialAddress = new Address(organizationORM.getOfficialAddress());
        this.annualTurnover = organizationORM.getAnnualTurnover();
        this.employeesCount = organizationORM.getEmployeesCount();
        this.fullName = organizationORM.getFullName();
        this.rating = organizationORM.getRating();

    }
}
