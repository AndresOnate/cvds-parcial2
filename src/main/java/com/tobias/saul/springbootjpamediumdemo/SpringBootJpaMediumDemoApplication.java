package com.tobias.saul.springbootjpamediumdemo;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tobias.saul.springbootjpamediumdemo.model.Employee;
import com.tobias.saul.springbootjpamediumdemo.service.EmployeeService;

@SpringBootApplication
public class SpringBootJpaMediumDemoApplication {

	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaMediumDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		return (args) -> {

			System.out.println("\nDeleting employee....");
			employeeService.deleteAllEmployees();
			
			System.out.println("Adding employees....\n");
			employeeService.addEmployee(new Employee("Andres", "Onate", "Salesman", 63000.00, LocalDate.of(2003, 1, 27) ));
			employeeService.addEmployee(new Employee("Jorge", "Useche", "Salesman", 63000.00, LocalDate.of(1990, 4, 26) ));

			
			System.out.println("\nGetting all employees....");
			employeeService.getAllEmployees().forEach(employee -> System.out.println(employee));
			
		};
	}

}
