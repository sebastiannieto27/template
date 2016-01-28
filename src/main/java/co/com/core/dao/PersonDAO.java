package co.com.core.dao;

import java.util.List;

import co.com.core.domain.Person;

public interface PersonDAO {
	public void save(Person p);
    
    public List<Person> list();
}
