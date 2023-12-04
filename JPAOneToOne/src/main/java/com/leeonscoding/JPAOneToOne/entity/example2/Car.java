package com.leeonscoding.JPAOneToOne.entity.example2;

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
    private int id;

    @Column(nullable = false, unique = true)
    private String number;

    private String model;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Employee employee;
}
