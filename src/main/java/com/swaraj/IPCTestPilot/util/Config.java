package com.swaraj.IPCTestPilot.util;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class Config {
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public OpenAPI swaggerDocApi() {
			
		Server server1 = new Server();
		server1.setUrl("http://localhost:8080/");
		server1.setDescription("Server for Testing");
		
		Server server2 = new Server();
		server2.setUrl("http://localhost:8090/");
		server2.setDescription("Server for Production");
		
		Contact co = new Contact();
		co.setEmail("Developer@gmail.com");
		co.setName("Test Pilot");
		co.setUrl("www.Developer.com");
		
		License license = new License();
		license.setName("License Provider: Approved by Google");
		license.setUrl("www.google.com");
		
		Info info = new Info();
		info.setContact(co);
		info.setLicense(license);
		info.setDescription(" Test Application for the Students of Qspiders/Jspiders ");
		info.setTermsOfService(" Url for terms and services ");
		info.setTitle(" IPC Test Pilot ");
		info.setVersion("1");
		
		OpenAPI api = new OpenAPI();
		api.setInfo(info);
		api.setServers(Arrays.asList(server1,server2));
		return api;
	}
	
}
