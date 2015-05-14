package com.hcmuaf.tanloc.service;

import java.util.List;

import com.hcmuaf.tanloc.model.Person;

public interface PersonService {
	public void createPerson(Person p);

	public void updatePerson(Person p);

	public List<Person> getListPerson();

	public Person getPersonById(int id);

	public void removePerson(int id);
}
