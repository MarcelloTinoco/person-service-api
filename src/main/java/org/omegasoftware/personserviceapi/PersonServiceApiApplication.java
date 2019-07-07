package org.omegasoftware.personserviceapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class PersonServiceApiApplication {

	@Value("${app.environment}")
	private String environment;
	
	public static void main(String[] args) {
		SpringApplication.run(PersonServiceApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println(">>>>>>>>>> - " + this.environment);
		};
	}
}
