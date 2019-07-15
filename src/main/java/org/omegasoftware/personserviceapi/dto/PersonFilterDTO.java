package org.omegasoftware.personserviceapi.dto;

import org.omegasoftware.personserviceapi.model.enums.OrderingType;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class PersonFilterDTO extends PersonDTO{

	private static final long serialVersionUID = -8437457224149488804L;
	private static int DEFAULT_REGISTER_PER_PAGE = 10;
	
	private int startRegister = 1;

	private int registerPerPage = DEFAULT_REGISTER_PER_PAGE;
	private String sortBy;
	private OrderingType order;
	public int getStartRegister() {
		return startRegister;
	}
	public void setStartRegister(int startRegister) {
		this.startRegister = startRegister;
	}
	public int getRegisterPerPage() {
		return registerPerPage;
	}
	public void setRegisterPerPage(int registerPerPage) {
		this.registerPerPage = registerPerPage;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public OrderingType getOrder() {
		return order;
	}
	public void setOrder(OrderingType order) {
		this.order = order;
	}
	
	
}
