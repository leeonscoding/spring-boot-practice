package com.leeonscoding.JPASpecificationsExample.pattern2;

import com.leeonscoding.JPASpecificationsExample.Employee;
import org.springframework.data.jpa.domain.Specification;

public interface EmployeeSpecificationDsl {

    static Specification<Employee> byExactEmail(String email) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), email);
    }

    static Specification<Employee> byNameLike(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }
}
