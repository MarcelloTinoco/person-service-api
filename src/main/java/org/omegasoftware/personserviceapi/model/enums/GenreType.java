package org.omegasoftware.personserviceapi.model.enums;

import org.springframework.util.StringUtils;

/**
 * An Enum type that represents person's genre
 * 
 * @author Marcello Tinoco
 *
 */
public enum GenreType {

	MALE("M"),
	FEMALE("F"),
	OTHERS("O");
	
	private String code;
	
	private GenreType(String sexTypeStr) {
		this.code = sexTypeStr;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public static GenreType getByCode(String genre) {
		if(!StringUtils.isEmpty(genre)) {
			if("M".equalsIgnoreCase(genre)) {
				return GenreType.MALE;
			}
			else if("F".equalsIgnoreCase(genre)) {
				return GenreType.FEMALE;
			}
			else if("O".equalsIgnoreCase(genre)) {
				return GenreType.OTHERS;
			}
			else return null;
		}
		return null;
	}
}
