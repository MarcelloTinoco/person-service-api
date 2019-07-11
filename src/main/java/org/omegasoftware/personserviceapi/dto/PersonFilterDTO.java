package org.omegasoftware.personserviceapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonFilterDTO extends PersonDTO{

	private static final long serialVersionUID = -8437457224149488804L;
	private static int DEFAULT_REGISTER_PER_PAGE = 10;
	
	private int startRegister = 1;
	private int registerPerPage = DEFAULT_REGISTER_PER_PAGE;
	private String sortBy;
	private String order;
	
	
}
