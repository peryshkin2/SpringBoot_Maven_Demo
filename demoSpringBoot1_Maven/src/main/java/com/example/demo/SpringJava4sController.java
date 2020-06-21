package com.example.demo;

//package com.java4s.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

//import com.example.repository.SpringJava4sDAO;
import com.example.model.Person;;

@RestController
public class SpringJava4sController {
	
	@Autowired
	public SpringJava4sDAO dao;
	
	@RequestMapping("/get-cust-info")
	public List<Person> customerInformation() {
		
		List<Person> customers = dao.isData();		 
		
		return customers;
	}
}
