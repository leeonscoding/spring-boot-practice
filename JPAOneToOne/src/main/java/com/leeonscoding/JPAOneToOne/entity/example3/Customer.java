package com.leeonscoding.JPAOneToOne.entity.example3;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "customer_card_mapping",
            joinColumns = {
                    @JoinColumn(name = "customer_id", referencedColumnName = "id"),

            },
            inverseJoinColumns = {
                    @JoinColumn(name = "card_id", referencedColumnName = "id")
            }
    )
    CreditCardInfo creditCardInfo;
}
