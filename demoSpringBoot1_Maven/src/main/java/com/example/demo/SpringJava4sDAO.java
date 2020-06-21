package com.example.demo;

import java.sql.Date;
import java.sql.Timestamp;

//package com.java4s.app.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Person;

@Repository
public class SpringJava4sDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String SQL = "select * from person";
	private static final String SQLid = "select * from person where person_id=?";
	
	
	public List<Person> isData() {
		
		List<Person> persons = new ArrayList<Person>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);
		
		for (Map<String, Object> row : rows) {
			Person person = new Person();
			
			person.setPersonId((int)row.get("person_id"));
			person.setName((String)row.get("name"));
			Date date = new Date(((Timestamp)row.get("birth_date")).getTime());
			person.setBirthDate(date);
			person.setEmail((String)row.get("email"));
			
			persons.add(person);
		}

		return persons;
		
	}
	
public List<Person> oneData(String id) {
		
		List<Person> persons = new ArrayList<Person>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQLid, id);
		
		for (Map<String, Object> row : rows) {
			Person person = new Person();
			
			person.setPersonId((int)row.get("person_id"));
			person.setName((String)row.get("name"));
			Date date = new Date(((Timestamp)row.get("birth_date")).getTime());
			person.setBirthDate(date);
			person.setEmail((String)row.get("email"));
			
			persons.add(person);
		}

		return persons;
		
	}
}
