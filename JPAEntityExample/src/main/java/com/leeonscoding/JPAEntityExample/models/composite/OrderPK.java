package com.leeonscoding.JPAEntityExample.models.composite;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Data
public class OrderPK {
    private int orderId;
    private int productId;
}
