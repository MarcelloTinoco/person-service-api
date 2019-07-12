package org.omegasoftware.personserviceapi.repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.omegasoftware.personserviceapi.dto.PersonFilterDTO;
import org.omegasoftware.personserviceapi.model.Person;

public class PersonCustomRepositoryImpl implements PersonCustomRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	private final static String SQL_BASE = 
			"SELECT p.id, "
			+ "p.first_name, "
			+ "p.last_name, "
			+ "p.cpf, "
			+ "p.email, "
			+ "p.age, "
			+ "p.genre, "
			+ "p.creation_date, "
			+ "p.update_date "
			+ "FROM person p";
	
	@Override
	public int countPersonFiltering(PersonFilterDTO filter) {
		StringBuffer sb =  new StringBuffer();
		sb.append("SELECT COUNT(*) FROM ( ");
		sb.append(SQL_BASE);
		sb.append(" ) as count");
		
		Query q = entityManager.createNativeQuery(sb.toString());
		Object result = q.getSingleResult();
		if(result!=null ) {
			if(result instanceof BigDecimal) {
				return ((BigDecimal)result).intValue();
			}
			else if (result instanceof BigInteger) {
				return ((BigInteger) result).intValue();
			}
			
		}
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findPersonFiltering(PersonFilterDTO filter) {
		Query q = entityManager.createNativeQuery(SQL_BASE, Person.class);
		if(filter!=null) {
			q.setFirstResult(filter.getStartRegister());
			q.setMaxResults(filter.getRegisterPerPage());
		}
		return (List<Person>)q.getResultList();
	}

	

}
