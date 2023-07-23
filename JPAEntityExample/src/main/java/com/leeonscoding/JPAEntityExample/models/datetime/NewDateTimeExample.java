package com.leeonscoding.JPAEntityExample.models.datetime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class NewDateTimeExample {
    @Id
    private long id;

    private LocalDate createdDate;
    private LocalTime createTime;
    private OffsetTime pauseTime;
    private LocalDateTime createdDateTime;
    private OffsetDateTime buyDateTime;
    private ZonedDateTime shippingTimestamp;
}
