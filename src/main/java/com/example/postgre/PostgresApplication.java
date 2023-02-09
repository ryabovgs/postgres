package com.example.postgre;

import com.example.postgre.entity.Customer;
import com.example.postgre.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories("com.example.postgre.repository")
public class PostgresApplication {
	private final Logger logger = LoggerFactory.getLogger(PostgresApplication.class);

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(PostgresApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
		queryAllCustomers();
		createCustomer();
		queryAllCustomers();
	}

	private void createCustomer() {
		Customer newCustomer = new Customer();
		newCustomer.setFirstName("John2");
		newCustomer.setLastName("Doe2");
		logger.info("Saving new customer...");
		this.repository.save(newCustomer).doOnNext(Customer::toString)
				.subscribe(System.out::println);
	}

	private void queryAllCustomers() {
		var allCustomers = this.repository.findAll()
				.doOnNext(Customer::toString)
				.collectList()
				.subscribe(customers -> {
					logger.info("Number of customers: " + customers.size());
				});
	}
}