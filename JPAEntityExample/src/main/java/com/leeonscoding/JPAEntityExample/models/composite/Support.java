package com.leeonscoding.JPAEntityExample.models.composite;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@IdClass(SupportPK.class)
public class Support {
    @Id
    private int customerId;
    @Id
    private int ticketId;
}
