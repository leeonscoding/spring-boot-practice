package com.leeonscoding.beansxml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeansXmlApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BeansXmlApplication.class, args);
	}


	@Autowired
	private Car car;

	@Override
	public void run(String... args) throws Exception {
		car.setName("toyota");
		car.setOrigin("japan");

		System.out.println("-------"+ car.getName() + " : "+car.getOrigin());


	}
}
