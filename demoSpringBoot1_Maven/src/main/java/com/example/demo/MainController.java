package com.example.demo;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path="/person") // This means URL's start with /person (after Application path)
public class MainController {
  @Autowired // This means to get the bean called personRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private PersonRepository personRepository;

  @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewPerson (@RequestParam String name, @RequestParam String dd
      , @RequestParam String email) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request
	// example of URL: curl -X POST http://localhost:8080/person/add -d name=Jakob -d dd="1955-05-25T05:00:00.000+0000" -d email=jjj@p.com
	  Date date = null;
	  try {
		  date = new SimpleDateFormat("yyyy-MM-dd").parse(dd); 
	  } catch (ParseException e) {
		  e.printStackTrace();
		  date = new Date();  
	  }
    Person n = new Person();
    n.setName(name);
    n.setBirthDate(date);
    n.setEmail(email);
    personRepository.save(n);
    return "Saved";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<Person> getAllPersons() {
    // This returns a JSON or XML with the Persons
    return personRepository.findAll();
  }
}

