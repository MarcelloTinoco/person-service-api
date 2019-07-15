package org.omegasoftware.personserviceapi.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.omegasoftware.personserviceapi.model.Person;
import org.omegasoftware.personserviceapi.model.enums.GenreType;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Marcello Tinoco
 *
 */
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO  extends ResourceSupport implements Serializable{

	private static final long serialVersionUID = 7924537803853230576L;
	
	private Long id;
	
	@NotEmpty(message = "CPF should not be empty.")
	@CPF(message = "CPF is invalid.")
	private String cpf;
	
	@NotEmpty(message = "First name should not be empty.")
	@Length(min = 3, max = 50, message = "First name should has between 3 and 50 characters.")
	private String firstName;
	
	private String lastName;
	
	@NotEmpty(message = "Email should not be empty.")
	@Email(message = "Invalid Email.")
	private String email;
	
	@NotNull(message = "Age should not be empty.")
	@Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 100, message = "Age should not be greater than 100")
	private Integer age;
	
	@NotNull(message = "Genre should not be empty.")
	private GenreType genre;
	
	
	public void setEntity(Person p) {
		if(p!=null) {
			BeanUtils.copyProperties(p, this);
		}
	}
	
	@JsonIgnore
	public Person getEntity() {
		Person p = new Person();
		BeanUtils.copyProperties(this, p);
		return p;
	}

	public Long getPersonId() {
		return id;
	}

	public void setPersonId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public GenreType getGenre() {
		return genre;
	}

	public void setGenre(GenreType genre) {
		this.genre = genre;
	}
}
