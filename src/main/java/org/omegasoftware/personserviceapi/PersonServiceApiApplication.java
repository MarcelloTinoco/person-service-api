package org.omegasoftware.personserviceapi;

import java.util.List;

import org.omegasoftware.personserviceapi.dto.PersonFilterDTO;
import org.omegasoftware.personserviceapi.model.Person;
import org.omegasoftware.personserviceapi.model.enums.GenreType;
import org.omegasoftware.personserviceapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class PersonServiceApiApplication {

	@Autowired
	private PersonRepository personRepository;
	
	@Value("${app.environment}")
	private String environment;
	
	public static void main(String[] args) {
		SpringApplication.run(PersonServiceApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			
			System.out.println("################################################################"); 
			System.out.println("Person Service API Running On Environment - " + this.environment); 
			System.out.println("################################################################"); 
			
			
			/*
			 * Person p = new Person(); p.setCpf("04266383797");
			 * p.setEmail("marcellojorge@gmail.com"); p.setFirstName("Marcello Jorge");
			 * p.setLastName("Costa Tinoco"); p.setGenre(GenreType.MALE); p.setAge(40);
			 * personRepository.save(p);
			 * 
			 * System.out.println(">>>>>>>>>> - " + this.environment); p = new Person();
			 * p.setCpf("43391432004"); p.setEmail("43391432004@gmail.com");
			 * p.setFirstName("43391432004_firstName");
			 * p.setLastName("43391432004_lastName"); p.setGenre(GenreType.FEMALE);
			 * p.setAge(20); personRepository.save(p);
			 * 
			 * 
			 * 
			 * Pageable pageByCpf = PageRequest.of(0, 1, Sort.by("firstName")); List<Person>
			 * person = personRepository.findByCpf("04266383797", pageByCpf);
			 * System.out.println(person);
			 * 
			 * PersonFilterDTO filter = new PersonFilterDTO();
			 * 
			 * int count = personRepository.countPersonFiltering(filter);
			 * System.out.println("Number of registers - " + count);
			 * 
			 * filter.setStartRegister(1); filter.setRegisterPerPage(1); List<Person> list =
			 * personRepository.findPersonFiltering(filter); list.forEach(pResult ->
			 * System.out.println(pResult));
			 */
			
		};
	}
}
