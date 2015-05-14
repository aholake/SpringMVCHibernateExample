package com.hcmuaf.tanloc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.hcmuaf.tanloc.model.Person;
import com.hcmuaf.tanloc.service.PersonService;

@Controller
public class PersonController {
	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/personList", method = RequestMethod.GET)
	public @ResponseBody List<Person> getList() {
		return personService.getListPerson();
	}
	@RequestMapping(value="/getPerson",method=RequestMethod.GET)
	public @ResponseBody Person getPerson(@RequestParam int id){
		return personService.getPersonById(id);
	}
}
