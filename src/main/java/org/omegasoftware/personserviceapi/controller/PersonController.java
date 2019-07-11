package org.omegasoftware.personserviceapi.controller;


import javax.validation.Valid;

import org.omegasoftware.personserviceapi.dto.PersonDTO;
import org.omegasoftware.personserviceapi.model.enums.GenreType;
import org.omegasoftware.personserviceapi.responses.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/person")
public class PersonController {

	@ApiOperation(value = "Get a Person By Id. This API is versioning, so pass X-API-Version=v1 in header in order to call resource", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Person"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
	@GetMapping(value = "/{id}", headers = "X-API-Version=v1", 
	            consumes =  MediaType.APPLICATION_JSON_UTF8_VALUE, 
		        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Response<PersonDTO>> getById(@PathVariable("id") long id) {
		
		Response<PersonDTO> response = new Response<PersonDTO>();
		PersonDTO personDTO = new PersonDTO();
		personDTO.setId(id);
		personDTO.setFirstName("José Bonifácio");
		personDTO.setLastName("De Andrada e Silva");
		personDTO.setGenre(GenreType.MALE);
		personDTO.setCpf("644.257.600-00");
		personDTO.setEmail("jose.bonifacio@imperio.br");
		personDTO.setAge(65);
		
		response.setData(personDTO);
		response.setNumberOfRegister(1);
		response.setTotalOfRegisters(1);
		
		return ResponseEntity.ok(response);
	}
	
	/**
	 * @Valid responsavel por executar a validacao.
	 * BindingResult responsavel por armazenar o resultado da validacao
	 * @param personDTO
	 * @return
	 */
	@PostMapping(consumes =  MediaType.APPLICATION_JSON_UTF8_VALUE, 
			     produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			     headers = "X-API-Version=v1")
	public ResponseEntity<Response<PersonDTO>> save(@Valid @RequestBody PersonDTO personDTO, BindingResult result) {
		
		Response<PersonDTO> response = new Response<PersonDTO>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		personDTO.setId(1L);
		response.setData(personDTO);
		
		return ResponseEntity.ok(response);
	}
	
}
