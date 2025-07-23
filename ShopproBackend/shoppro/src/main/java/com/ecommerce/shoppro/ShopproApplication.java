package com.ecommerce.shoppro;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ecommerce.shoppro.domain.Role;
import com.ecommerce.shoppro.repo.RoleRepository;

@SpringBootApplication
public class ShopproApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopproApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(RoleRepository roleRepo) {
		return args-> {
			if(roleRepo.findByName("ROLE_USER").isEmpty()) {
				roleRepo.save(new Role(null,"ROLE_USER"));
			}
			if(roleRepo.findByName("ROLE_ADMIN").isEmpty()) {
				roleRepo.save(new Role(null,"ROLE_ADMIN"));
			}
		};
	}

}
