package com.example.model;

import java.util.Date;

//package com.java4s.model;

public class Person {
	
	private int personId;
	private String name;
	private Date birthDate;
	private String email;
	
	public Person() {		
	}
	
	public Person(int personId, String name, Date birthDate, String email) {
		this.personId = personId;
		this.name = name;
		this.birthDate = birthDate;
		this.email = email;
	}

	public int getPersonId() {
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

