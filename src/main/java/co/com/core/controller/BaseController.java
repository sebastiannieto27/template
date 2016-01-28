package co.com.core.controller;

import java.util.List;

import co.com.core.dao.PersonDAO;
import co.com.core.domain.Person;
import co.com.core.services.IBaseService;

public class BaseController {

	private IBaseService baseService;

	private PersonDAO personDAO;
	
	private Person person;
	
	public void createPerson() {
		Person person = new Person();
        person.setName("Diego"); 
        person.setCountry("Colombia");
        
        personDAO.save(person);
	}
	
	public void findPerson() {
		
        List<Person> list = personDAO.list();
         
        if(list!=null && list.size() > 0) {
        	person = list.get(0);
        	System.out.println("PERSON: " + person.getName());
        }
	}
	
	public IBaseService getBaseService() {
		return baseService;
	}

	public void setBaseService(IBaseService baseService) {
		this.baseService = baseService;
	}
	
	public String getProp1() {
		return "prop1Value";
	}

	public PersonDAO getPersonDAO() {
		return personDAO;
	}

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
