package org.omegasoftware.personserviceapi.repository;

import java.util.List;

import org.omegasoftware.personserviceapi.dto.PersonFilterDTO;
import org.omegasoftware.personserviceapi.model.Person;

public interface PersonCustomRepository {

	int countPersonFiltering(PersonFilterDTO filter);
	List<Person> findPersonFiltering(PersonFilterDTO filter);
}
