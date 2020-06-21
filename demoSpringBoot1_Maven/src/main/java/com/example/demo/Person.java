package com.example.demo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hbernate to make a table out of this class
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer personId;
	private String name;
	private Date birthDate;
	private String email;
	
	public Person() {		
	}
	
	public Person(Integer personId, String name, Date birthDate, String email) {
		this.personId = personId;
		this.name = name;
		this.birthDate = birthDate;
		this.email = email;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}

