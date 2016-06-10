package me.moriya.service.impl;

import me.moriya.entity.Person;
import me.moriya.repository.GenericRepository;
import me.moriya.service.PersonService;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by andre on 6/10/16.
 */
@Named
class PersonServiceImpl implements PersonService, Serializable {

    private static final long serialVersionUID = 3435614315146588265L;

    @Inject
    private GenericRepository<Person, Long> personRepository;

    public List<Person> list() {
        return this.personRepository.list();
    }

    public void save(Person person) {
        this.personRepository.save(person);
    }
}
