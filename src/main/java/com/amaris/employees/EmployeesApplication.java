package com.amaris.employees;

import com.amaris.employees.repository.EmployeeRepository;
import com.amaris.employees.repository.impl.EmployeeRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
/*@ComponentScan("com.amaris.employees.repository")*/
public class EmployeesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeesApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public EmployeeRepository employeeRepository() {
		return new EmployeeRepositoryImpl(restTemplate());
	}

}
