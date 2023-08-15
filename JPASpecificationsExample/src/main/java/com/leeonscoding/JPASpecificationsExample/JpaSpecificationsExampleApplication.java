package com.leeonscoding.JPASpecificationsExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JpaSpecificationsExampleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpaSpecificationsExampleApplication.class, args);
	}

	@Autowired
	EmployeeService employeeService;

	@Override
	public void run(String... args) throws Exception {
		Employee e1 = Employee.builder()
							.email("john@mail.com")
							.name("john")
							.phone("123")
							.build();

		Employee e2 = Employee.builder()
				.email("bell@mail.com")
				.name("bell")
				.phone("134")
				.build();

		Employee e3 = Employee.builder()
				.email("rony@mail.com")
				.name("rony")
				.phone("156")
				.build();

		employeeService.addEmployee(e1);
		employeeService.addEmployee(e2);
		employeeService.addEmployee(e3);

		List<Employee> list1 = employeeService.findAllEmployee();

		List<Employee> list2 = employeeService.findAllEmployee2("rony", "ron");
	}
}
