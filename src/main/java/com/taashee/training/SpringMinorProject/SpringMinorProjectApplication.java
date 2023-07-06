package com.taashee.training.SpringMinorProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SpringMinorProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMinorProjectApplication.class, args);
		System.out.println("hii");
	}

}
