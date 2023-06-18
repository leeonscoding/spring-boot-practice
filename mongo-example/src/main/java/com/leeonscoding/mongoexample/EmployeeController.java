package com.leeonscoding.mongoexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addEmployee(@RequestBody EmployeeInput employee) {
        Employee employee1 = Employee.builder()
                                    .name(employee.name())
                                    .email(employee.email())
                                    .role(employee.role())
                                    .build();
        employeeRepository.save(employee1);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
    }

}
