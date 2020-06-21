package com.example.demo;

//package com.java4s.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//import com.example.repository.SpringJava4sDAO;
import com.example.model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;;

@Controller
public class SpringJava1sController2 {
	
	@Autowired
	public SpringJava4sDAO dao;
	
	@RequestMapping("/get-cust-info1")
	
	@GetMapping
	public ModelAndView customerInformationId(@RequestParam(defaultValue="1") String id) {
		String jsonString="";
		List<Person> customers = dao.oneData(id);	
		
		//Creating the ObjectMapper object
	      ObjectMapper mapper = new ObjectMapper();
	      //Converting the Object to JSONString
	      try {
			jsonString = mapper.writeValueAsString(customers);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		mv.addAttribute("customer","Welcome home mannn");
		 ModelAndView mv = new ModelAndView();
	        mv.setViewName("customerview");
	        mv.getModel().put("customer", jsonString);
	 
	        return mv;
//		return "customerview";
	}
}
