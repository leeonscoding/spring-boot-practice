package com.leeonscoding.JPASpecificationsExample;

public record SearchCriteria(String key,
                             String operation,
                             String value) {
}
