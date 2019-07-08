package org.omegasoftware.personserviceapi.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.omegasoftware.personserviceapi.model.enums.GenreType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Marcello Tinoco
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO implements Serializable{

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
}
