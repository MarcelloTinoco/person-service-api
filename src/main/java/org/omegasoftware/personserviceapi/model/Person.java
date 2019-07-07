package org.omegasoftware.personserviceapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.omegasoftware.personserviceapi.model.enums.GenreType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A Class that represents a person in a model
 * 
 * @author Marcello Tinoco
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="person")
public class Person implements Serializable{

	private static final long serialVersionUID = 653353114401752787L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	
	@Column(name="cpf", nullable=false)
	private String cpf;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="age")
	private int age;
	
	@Enumerated(EnumType.STRING)
	@Column(name="genre")
	private GenreType genre;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creation_date", nullable = false)
	private Date creationDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;
		
	public Person (String cpf, String firstName, String email, int age) {
		this.cpf = cpf;
		this.firstName = firstName;
		this.email = email;
		this.age = age;
	}

	@PrePersist
	public void prePersist() {
		this.creationDate = new Date();
	}
	
	@PreUpdate
	public void preUpdate() {
		this.updateDate = new Date();
	}
	
}
