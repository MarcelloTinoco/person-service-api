package org.omegasoftware.personserviceapi.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.omegasoftware.personserviceapi.dto.PersonDTO;
import org.omegasoftware.personserviceapi.dto.PersonFilterDTO;
import org.omegasoftware.personserviceapi.exceptions.ServiceException;
import org.omegasoftware.personserviceapi.model.Person;
import org.omegasoftware.personserviceapi.model.services.PersonService;
import org.omegasoftware.personserviceapi.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/person")
public class PersonController {

	private PersonService service;
	
	@Autowired
	PersonController(PersonService service){
		this.service = service;
	}
	
	@ApiOperation(value = "Get a Person By Id. This API is versioning, so pass X-API-Version=v1 in header in order to call resource", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Person"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
	@GetMapping(value = "/{id}", headers = "X-API-Version=v1", 
	            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Response<PersonDTO>> getById(@PathVariable("id") long id) {
		
		ResponseEntity<Response<PersonDTO>> response = null;
		Response<PersonDTO> responseDTO = new Response<PersonDTO>();
		try {
			Person p = service.getById(id);
			PersonDTO pDTO = new PersonDTO();
			pDTO.setEntity(p);
			Link selfLink = ControllerLinkBuilder.linkTo(PersonController.class).slash(p.getId()).withSelfRel();
			pDTO.add(selfLink);
			responseDTO.setData(pDTO);
			responseDTO.setNumberOfRegister(1);
			responseDTO.setTotalOfRegisters(1);
			
			response = ResponseEntity.ok(responseDTO);
		}
		catch(Exception ex) {
			
			responseDTO.getErrors().add(ex.getMessage());
			response = ResponseEntity.badRequest().body(responseDTO);
		}
				
		return response;
	}
	
	/**
	 * @Valid responsavel por executar a validacao.
	 * BindingResult responsavel por armazenar o resultado da validacao
	 * @param personDTO
	 * @return
	 */
	@ApiOperation(value = "Save a Person. This API is versioning, so pass X-API-Version=v1 in header in order to call resource", response = Iterable.class)
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully posted Person"),
	            @ApiResponse(code = 401, message = "You are not authorized to post the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "Error when trting to post a person")})
	@PostMapping(consumes =  MediaType.APPLICATION_JSON_UTF8_VALUE, 
			     produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			     headers = "X-API-Version=v1")
	public ResponseEntity<Response<PersonDTO>> save(@Valid @RequestBody PersonDTO personDTO, BindingResult result) {
		
		ResponseEntity<Response<PersonDTO>> response = null;
		Response<PersonDTO> responseDTO = new Response<PersonDTO>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> responseDTO.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(responseDTO);
		}
		else {
			try {
				Person p = personDTO.getEntity();
				service.save(p);
				personDTO.setEntity(p);
				Link selfLink = ControllerLinkBuilder.linkTo(PersonController.class).slash(p.getId()).withSelfRel();
				personDTO.add(selfLink);
				responseDTO.setData(personDTO);
				responseDTO.setNumberOfRegister(1);
				responseDTO.setTotalOfRegisters(1);
				//Link selfLink = linkTo(methodOn(PersonController.class).getById(p.getId()).withSelfRel());
				
				response = ResponseEntity.ok(responseDTO);
			}
			catch(ServiceException ex) {
				responseDTO.getErrors().add(ex.getMessage());
				response = ResponseEntity.badRequest().body(responseDTO);
			}
		}
			
		return response;
	}
	
	@ApiOperation(value = "Update a Person. This API is versioning, so pass X-API-Version=v1 in header in order to call resource", response = Iterable.class)
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully put a Person"),
	            @ApiResponse(code = 401, message = "You are not authorized to put the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "Error when trting to put a person")})
	@PutMapping(consumes =  MediaType.APPLICATION_JSON_UTF8_VALUE, 
			     produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			     headers = "X-API-Version=v1")
	public ResponseEntity<Response<PersonDTO>> update(@Valid @RequestBody PersonDTO personDTO, BindingResult result) {
		
		ResponseEntity<Response<PersonDTO>> response = null;
		Response<PersonDTO> responseDTO = new Response<PersonDTO>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> responseDTO.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(responseDTO);
		}
		else {
			try {
				Person p = personDTO.getEntity();
				service.save(p);
				personDTO.setEntity(p);
				Link selfLink = ControllerLinkBuilder.linkTo(PersonController.class).slash(p.getId()).withSelfRel();
				personDTO.add(selfLink);
				responseDTO.setData(personDTO);
				responseDTO.setNumberOfRegister(1);
				responseDTO.setTotalOfRegisters(1);
				//Link selfLink = linkTo(methodOn(PersonController.class).getById(p.getId()).withSelfRel());
				
				response = ResponseEntity.ok(responseDTO);
			}
			catch(ServiceException ex) {
				responseDTO.getErrors().add(ex.getMessage());
				response = ResponseEntity.badRequest().body(responseDTO);
			}
		}
			
		return response;
	}
	
	
	/**
	 * @Valid responsavel por executar a validacao.
	 * BindingResult responsavel por armazenar o resultado da validacao
	 * @param personDTO
	 * @return
	 */
	@DeleteMapping(value = "/{id}", consumes =  MediaType.APPLICATION_JSON_UTF8_VALUE, 
			     produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			     headers = "X-API-Version=v1")
	@ApiOperation(value = "Delete a Person By Id. This API is versioning, so pass X-API-Version=v1 in header in order to call resource", response = Iterable.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted"),
            @ApiResponse(code = 401, message = "You are not authorized to delete the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to delete is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to delete is not found")})
	public ResponseEntity<Response<PersonDTO>> delete(@PathVariable("id") long id){
		ResponseEntity<Response<PersonDTO>> response = null;
		Response<PersonDTO> responseDTO = new Response<PersonDTO>();
		try {
			service.deleteById(id);
			response = ResponseEntity.status(HttpStatus.OK).body(responseDTO);
		}
		catch(ServiceException ex) {
			responseDTO.getErrors().add(ex.getMessage());
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
		}
		
		return response;
	}
	
	@ApiOperation(value = "Find People Paginated. This API is versioning, so pass X-API-Version=v1 in header in order to call resource", response = Iterable.class)
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully find people"),
	            @ApiResponse(code = 401, message = "You are not authorized to find resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "Error when trying to find people")})
	@PostMapping(path = "/findPaginated", 
	             consumes =  MediaType.APPLICATION_JSON_UTF8_VALUE, 
			     produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			     headers = "X-API-Version=v1")
	public ResponseEntity<Response<ArrayList<PersonDTO>>> findPaginated(@RequestBody PersonFilterDTO filter){
		ResponseEntity<Response<ArrayList<PersonDTO>>> response = null;
		Response<ArrayList<PersonDTO>> responseDTO = new Response<ArrayList<PersonDTO>>();
		try {
			int count = service.getNumberOfRegister(filter);
			List<Person> list = service.getPaginated(filter);
			if(list!=null && !list.isEmpty()) {
				ArrayList<PersonDTO> listPersonDTO = new ArrayList<PersonDTO>();
				list.forEach(p -> {
					PersonDTO pDTO = new PersonDTO();
					pDTO.setEntity(p);
					Link selfLink = ControllerLinkBuilder.linkTo(PersonController.class).slash(p.getId()).withSelfRel();
					pDTO.add(selfLink);
					listPersonDTO.add(pDTO);
				});
				responseDTO.setData(listPersonDTO);
				responseDTO.setTotalOfRegisters(count);
				responseDTO.setNumberOfRegister(listPersonDTO.size());
			}
			response = ResponseEntity.ok().body(responseDTO);
		}
		catch(Exception ex) {
			
		}
		
		return response;
	}
}
