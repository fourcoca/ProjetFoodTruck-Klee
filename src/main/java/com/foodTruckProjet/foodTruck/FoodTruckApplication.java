package com.foodTruckProjet.foodTruck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.foodTruckProjet.foodTruck"})
public class FoodTruckApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodTruckApplication.class, args);
	}

}
