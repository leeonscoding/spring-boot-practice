package com.leeonscoding.JPAEntityExample.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class AppUser {
    @Id
    @GeneratedValue(
            strategy = GenerationType.TABLE,
            generator="user_generator"
    )
    @TableGenerator(
            name = "user_generator",
            table = "user_seq",
            pkColumnName = "seq_id",
            valueColumnName = "seq_value"
    )
    private int id;

    @Column(name = "email", length = 25, nullable = false, unique = true)
    private String email;

    private String firstName;

    private String lastName;

    @Transient
    private String fullName;

    @Enumerated(value = EnumType.STRING)
    private UserType userType;

}