package com.leeonscoding.JPAEntityExample.models.composite;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class SupportPK {
    private int customerId;
    private int ticketId;
}
