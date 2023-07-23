package com.leeonscoding.JPAEntityExample.models.composite;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class OrderEntry {
    @EmbeddedId
    private OrderPK id;
}
