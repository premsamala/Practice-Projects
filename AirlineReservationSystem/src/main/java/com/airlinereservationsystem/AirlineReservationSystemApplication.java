package com.airlinereservationsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages= {"com.airlinereservationsystem"})
public class AirlineReservationSystemApplication extends SpringBootServletInitializer {
	@Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(AirlineReservationSystemApplication.class);
	    }
	public static void main(String[] args) {
		SpringApplication.run(AirlineReservationSystemApplication.class, args);
	}
}
