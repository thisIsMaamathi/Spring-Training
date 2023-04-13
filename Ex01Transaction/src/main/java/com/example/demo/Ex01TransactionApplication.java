package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.model.TransactionService;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(basePackages = {"com"})

public class Ex01TransactionApplication {
	/**
	 The Ex01TransactionApplication class is the entry point of the Spring Boot application.
The main method is used to run the Spring Boot application and returns a ConfigurableApplicationContext.
The moneyTransfer method of the TransactionService class is called with three arguments: source account id, destination account id, and the amount to be transferred..
	 */
	
	public static void main(String[] args) throws Exception {
       ConfigurableApplicationContext configurableApplicationContext =  SpringApplication.run(Ex01TransactionApplication.class, args);
		
		TransactionService transactionService = configurableApplicationContext.getBean("tss", TransactionService.class);
		transactionService.moneyTransfer(100, 1010,-2);
	}
}

