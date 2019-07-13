package org.omegasoftware.personserviceapi.model.services;

import java.util.List;

import org.omegasoftware.personserviceapi.dto.PersonFilterDTO;
import org.omegasoftware.personserviceapi.exceptions.ServiceException;
import org.omegasoftware.personserviceapi.model.Person;

public interface PersonService {
	
	public Person getById(Long id) throws ServiceException;
	public List<Person> getAll() throws ServiceException;
	public void save(Person p) throws ServiceException;
	public void deleteById(Long id) throws ServiceException;
	public int getNumberOfRegister(PersonFilterDTO filter) throws ServiceException;
	public List<Person> getPaginated(PersonFilterDTO filter) throws ServiceException;
}
