package com.usa.divinacomedia;

import com.usa.divinacomedia.app.repositories.Crud.HairProductCrudRepository;
import com.usa.divinacomedia.app.repositories.Crud.OrderCrudRepository;
import com.usa.divinacomedia.app.repositories.Crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DivinacomediaApplication implements CommandLineRunner {

	@Autowired
	private HairProductCrudRepository productRepository;

	@Autowired
	private UserCrudRepository userRepository;

	@Autowired
	private OrderCrudRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(DivinacomediaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.deleteAll();
		userRepository.deleteAll();
		orderRepository.deleteAll();
	}
}
