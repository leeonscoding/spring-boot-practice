package com.leeonscoding.JPAEntityExample.models.datetime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class TemporalExample {
    @Id
    private long id;

    // util.Date
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Temporal(TemporalType.TIME)
    private Date createdTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTimestamp;

    // Calender api
    @Temporal(TemporalType.DATE)
    private Calendar updatedDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar updatedTimestamp;
}
