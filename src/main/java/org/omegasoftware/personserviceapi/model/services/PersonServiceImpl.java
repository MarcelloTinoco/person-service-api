package org.omegasoftware.personserviceapi.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.omegasoftware.personserviceapi.dto.PersonFilterDTO;
import org.omegasoftware.personserviceapi.exceptions.ServiceException;
import org.omegasoftware.personserviceapi.model.Person;
import org.omegasoftware.personserviceapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{

	private PersonRepository repository;
	
	@Autowired
	PersonServiceImpl(PersonRepository repository){
		this.repository = repository;
	}
	
	@Override
	public Person getById(Long id) throws ServiceException {
		Optional<Person> o = repository.findById(id);
		return o.orElse(null);
	}

	@Override
	public List<Person> getAll() throws ServiceException {
		List<Person> resultList = new ArrayList<Person>();
		repository.findAll().iterator().forEachRemaining(p -> resultList.add(p));
		return resultList;
	}

	@Override
	public void save(Person p) throws ServiceException {
		repository.save(p);
		
	}

	@Override
	public void deleteById(Long id) throws ServiceException {
		if(repository.existsById(id)) {
			repository.deleteById(id);
		}
		else {
			throw new ServiceException("Person with given id was not found.");
		}
		
	}

	@Override
	public int getNumberOfRegister(PersonFilterDTO filter) throws ServiceException {
		return repository.countPersonFiltering(filter);
	}

	@Override
	public List<Person> getPaginated(PersonFilterDTO filter) throws ServiceException {
		return repository.findPersonFiltering(filter);
	}
	
}
