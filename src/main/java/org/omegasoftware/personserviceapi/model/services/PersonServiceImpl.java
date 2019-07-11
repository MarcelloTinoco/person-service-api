package org.omegasoftware.personserviceapi.model.services;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.omegasoftware.personserviceapi.dto.PersonFilterDTO;
import org.omegasoftware.personserviceapi.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{

	@Override
	public Person getById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getAll() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberOfRegister(PersonFilterDTO filter) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Person> getPaginated(PersonFilterDTO filter) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Person p) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Person p) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	
	
}
