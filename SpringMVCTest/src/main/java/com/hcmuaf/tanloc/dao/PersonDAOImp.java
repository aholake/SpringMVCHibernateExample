package com.hcmuaf.tanloc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcmuaf.tanloc.model.Person;

@Repository
public class PersonDAOImp implements PersonDAO{
	public static final Logger log = LoggerFactory.getLogger(Person.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void createPerson(Person p) {
		sessionFactory.getCurrentSession().persist(p);
		log.info("Added person succeed, INFO: "+p);
		
	}

	@Override
	public void updatePerson(Person p) {
		sessionFactory.getCurrentSession().update(p);
		log.info("Updated person succeed, INFO: "+p);
		
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Person> getListPerson() {
		List<Person> list = sessionFactory.getCurrentSession().createQuery("from Person").list();
		for (Person person : list) {
			log.info("Get list: "+person);
		}
		return list;
	}

	@Override
	public Person getPersonById(int id) {
		Person p =(Person) sessionFactory.getCurrentSession().load(Person.class, new Integer(id));
		log.info("Get Person: "+p);
		return p;
	}

	@Override
	public void removePerson(int id) {
		Person p =(Person) sessionFactory.getCurrentSession().load(Person.class, id);
		if(p!=null){
			sessionFactory.getCurrentSession().delete(p);
		}
		log.info("Deleted succeed");
	}

}
