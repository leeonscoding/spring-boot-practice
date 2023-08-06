package com.leeonscoding.liquibasegradleexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LiquibaseGradleExampleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiquibaseGradleExampleApplication.class, args);
	}

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		var e1 = new Employee();
		e1.setName("leeon");
		e1.setEmail("leeon@mail.com");
		e1.setPhone("123");

		var e2 = new Employee();
		e2.setName("siam");
		e2.setEmail("siam@mail.com");
		e2.setPhone("567");

		//employeeRepository.save(e1);
		//employeeRepository.save(e2);

		employeeRepository
				.findAll()
				.forEach(employee -> System.out.println(employee.getName()));
	}

}
