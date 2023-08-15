package com.leeonscoding.JPASpecificationsExample.pattern1;

import com.leeonscoding.JPASpecificationsExample.Employee;
import com.leeonscoding.JPASpecificationsExample.SearchCriteria;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification implements Specification<Employee> {

    private final SearchCriteria searchCriteria;

    public EmployeeSpecification(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (searchCriteria.operation().equals("like")) {
            return criteriaBuilder.equal(root.get(searchCriteria.key()), "%" + searchCriteria.value() + "%");
        }
        return criteriaBuilder.equal(root.get(searchCriteria.key()), searchCriteria.value());
    }
}
