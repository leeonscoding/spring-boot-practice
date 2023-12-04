package com.leeonscoding.JPAOneToOne.entity.example1;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(nullable = false, unique = true)
    private String number;

    private String model;

    @OneToOne(mappedBy = "car")
    private Employee employee;

    public void addEmployee(Employee employee) {
        employee.setCar(this);
        this.employee = employee;
    }

    public void removeEmployee() {
        if(employee != null) {
            employee.setCar(null);
            this.employee = null;
        }
    }
}