package me.moriya.service;

import me.moriya.entity.Person;

import java.util.List;

/**
 * Created by andre on 6/10/16.
 */
public interface PersonService {

    public List<Person> list();

    public void save(Person person);
}
