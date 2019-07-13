package org.omegasoftware.personserviceapi.responses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

/**
 * Class that represents a caller response
 * 
 * @author Marcello Tinoco
 *
 * @param <T>
 */
public class Response<T> extends ResourceSupport {

	/**
	 * Data retrieved
	 */
	private T data;
	/**
	 * A list of errors
	 */
	private List<String> errors;
	/**
	 * The number of register returned
	 */
	private int numberOfRegister;
	
	/**
	 * The total of register
	 */
	private int totalOfRegisters;
	
	public Response() {
		
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
		
	}

	public List<String> getErrors() {
		if (this.errors == null) {
			this.errors = new ArrayList<String>();
		}
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public int getNumberOfRegister() {
		return numberOfRegister;
	}

	public void setNumberOfRegister(int numberOfRegister) {
		this.numberOfRegister = numberOfRegister;
	}

	public int getTotalOfRegisters() {
		return totalOfRegisters;
	}

	public void setTotalOfRegisters(int totalOfRegisters) {
		this.totalOfRegisters = totalOfRegisters;
	}

	
	
	
}
