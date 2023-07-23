package com.leeonscoding.JPAEntityExample.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(generator = "emp_generator")
    @GenericGenerator(
            name = "emp_generator",
            strategy = "com.leeonscoding.JPAEntityExample.models.EmployeeIdGenerator",
            parameters = @Parameter(name = "prefix", value = "emp")
    )
    private int id;
}
