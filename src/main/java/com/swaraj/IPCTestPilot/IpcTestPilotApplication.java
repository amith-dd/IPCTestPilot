package com.swaraj.IPCTestPilot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class IpcTestPilotApplication {

	private static final Logger logger = LoggerFactory.getLogger(IpcTestPilotApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(IpcTestPilotApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		logger.info("CORS Configuration bean created");
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*")
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD").allowedHeaders("*");
			}
		};
	}
	
	 public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**").allowedMethods("*");
	    }

}
