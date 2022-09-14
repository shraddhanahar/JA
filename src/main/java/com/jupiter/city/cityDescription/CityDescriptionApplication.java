package com.jupiter.city.cityDescription;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages ={"com.jupiter.city.cityDescription.*"})
@EntityScan(basePackages = {"com.jupiter.city.cityDescription.Entity"})
@EnableJpaRepositories(basePackages = {"com.jupiter.city.cityDescription.repository"})
public class CityDescriptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityDescriptionApplication.class, args);
	}

}
