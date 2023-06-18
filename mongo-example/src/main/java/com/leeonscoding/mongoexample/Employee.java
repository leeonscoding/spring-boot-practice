package com.leeonscoding.mongoexample;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
public class Employee {
    @Id
    private String id;
    private String name;
    private String email;
    private String role;
}
