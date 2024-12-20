package com.example.lab1.orms;

import com.example.lab1.dtos.Organization;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Setter
@Getter
@Entity
@Table(name = "organizations")
public class OrganizationORM {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // Значение этого поля должно быть уникальным и генерироваться автоматически

    @Column(name = "name", nullable = false)
    private String name; // Поле не может быть null, строка не может быть пустой

    @Column(name = "annual_turnover")
    private int annualTurnover; // Значение поля должно быть больше 0

    @Column(name = "employees_count")
    private int employeesCount; // Значение поля должно быть больше 0

    @Column(name = "full_name")
    private String fullName; // Поле может быть null

    @Column(name = "rating")
    private Double rating; // Поле может быть null, значение поля должно быть больше 0

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "address_id", nullable = false)
    private AddressORM officialAddress; // Поле не может быть null

    public OrganizationORM(String name, AddressORM officialAddress, int annualTurnover, int employeesCount, String fullName, Double rating) {
        this.name = name;
        this.officialAddress = officialAddress;
        this.annualTurnover = annualTurnover;
        this.employeesCount = employeesCount;
        this.fullName = fullName;
        this.rating = rating;
    }

    public OrganizationORM() {}

    public OrganizationORM(Organization organization) {
        // this.id = organization.getId();
        this.name = organization.getName();
        this.annualTurnover = organization.getAnnualTurnover();
        this.employeesCount = organization.getEmployeesCount();
        this.fullName = organization.getFullName();
        this.rating = organization.getRating();
        this.officialAddress = new AddressORM(organization.getOfficialAddress());
    }
}
