package com.te.springbootemp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@JsonComponent
public class SpringbootempApplication {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootempApplication.class, args);
		
	
	}
	

}
