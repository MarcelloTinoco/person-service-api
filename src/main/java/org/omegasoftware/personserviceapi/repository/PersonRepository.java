package org.omegasoftware.personserviceapi.repository;

import java.util.List;

import org.omegasoftware.personserviceapi.model.Person;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>, PersonCustomRepository{

	List<Person> findByCpf(String cpf, Pageable page);
	List<Person> findByFirstName(String firstName, Pageable page);
	List<Person> findByEmail(String email, Pageable page);

}
