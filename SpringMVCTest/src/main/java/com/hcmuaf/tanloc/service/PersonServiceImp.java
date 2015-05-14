package com.hcmuaf.tanloc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcmuaf.tanloc.dao.PersonDAO;
import com.hcmuaf.tanloc.model.Person;

@Service
public class PersonServiceImp implements PersonService {

	@Autowired
	private PersonDAO personDAO;

	@Override
	@Transactional
	public void createPerson(Person p) {
		personDAO.createPerson(p);
	}

	@Override
	@Transactional
	public void updatePerson(Person p) {
		personDAO.updatePerson(p);
	}
	@Transactional
	@Override
	public List<Person> getListPerson() {
		return personDAO.getListPerson();
	}

	@Override
	@Transactional
	public Person getPersonById(int id) {
		return personDAO.getPersonById(id);
	}

	@Override
	@Transactional
	public void removePerson(int id) {
		personDAO.removePerson(id);
	}

}
