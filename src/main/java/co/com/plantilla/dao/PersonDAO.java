package co.com.plantilla.dao;

import java.util.List;

import co.com.plantilla.domain.Person;

public interface PersonDAO {
	public void save(Person p);
    
    public List<Person> list();
}
