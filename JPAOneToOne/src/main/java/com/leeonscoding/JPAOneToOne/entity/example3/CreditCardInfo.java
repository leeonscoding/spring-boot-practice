package com.leeonscoding.JPAOneToOne.entity.example3;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "credit_card_info")
public class CreditCardInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int cardNumber;

    @OneToOne(mappedBy = "creditCardInfo")
    private Customer customer;
}
