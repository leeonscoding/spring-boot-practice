package com.leeonscoding.JPASpecificationsExample;

import com.leeonscoding.JPASpecificationsExample.pattern1.EmployeeSpecification;
import com.leeonscoding.JPASpecificationsExample.pattern2.EmployeeSpecificationDsl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployee() {
        Sort sort = Sort.sort(Employee.class).by(Employee::getEmail).ascending()
                .and(Sort.sort(Employee.class).by(Employee::getName).ascending());

        Pageable page = PageRequest.of(0, 10, sort);

        EmployeeSpecification nameSpec = new EmployeeSpecification(new SearchCriteria("name", "like", "john"));
        EmployeeSpecification emailSpec = new EmployeeSpecification(new SearchCriteria("email", "=", "john@mail.com"));

        try (Stream<Employee> list = employeeRepository
                                        .findAll(nameSpec.and(emailSpec), page)
                                        .stream()) {
            return list.toList();
        } catch (Exception e) {

        }
        return null;
    }

    public List<Employee> findAllEmployee2(String email, String name) {
        Sort sort = Sort.sort(Employee.class).by(Employee::getEmail).ascending()
                .and(Sort.sort(Employee.class).by(Employee::getName).ascending());

        Pageable page = PageRequest.of(0, 10, sort);

        Stream<Employee> stream = employeeRepository.findAll(EmployeeSpecificationDsl.byExactEmail(email)
                                                    .and(EmployeeSpecificationDsl.byNameLike(name))
                                    , page).stream();
        return stream.toList();
    }
}
