package io.merch.amazon.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DTOConfig {
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
