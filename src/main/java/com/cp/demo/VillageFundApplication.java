package com.cp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages= {"com.cp.demo", "com.cp.model"})
public class VillageFundApplication {

	public static void main(String[] args) {
		SpringApplication.run(VillageFundApplication.class, args);
	}

}
