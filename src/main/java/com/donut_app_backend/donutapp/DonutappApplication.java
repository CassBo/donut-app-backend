package com.donut_app_backend.donutapp;

import com.donut_app_backend.donutapp.model.Category;
import com.donut_app_backend.donutapp.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.donut_app_backend.donutapp.repository.CategoryRepository;
import com.donut_app_backend.donutapp.repository.ProductRepository;

import java.util.*;

@SpringBootApplication
public class DonutappApplication {
	public static void main(String[] args) {
		SpringApplication.run(DonutappApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(CategoryRepository categoryRepo, ProductRepository productRepo) {
		return args -> {
			Category donuts = new Category("Donuts", "Dulces donas glaseadas o rellenas");
			Category burgers = new Category("Burgers", "Jugosas hamburguesas con distintos toppings");
			categoryRepo.saveAll(Arrays.asList(donuts, burgers));

			productRepo.save(new Product("Glazed Donut", "Dona con glaseado clásico", 1.50, "url1", true, donuts));
			productRepo.save(new Product("Cheeseburger", "Clásica hamburguesa con queso", 4.99, "url8", true, burgers));
		};
	}
}