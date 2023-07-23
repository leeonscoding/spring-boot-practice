package com.leeonscoding.JPAEntityExample.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class HashKey {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="key_generator"
    )
    @SequenceGenerator(
            name = "key_generator",
            sequenceName = "key_seq",
            initialValue = 100,
            allocationSize = 20
    )
    private int id;
}
