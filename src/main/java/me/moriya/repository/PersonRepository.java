package me.moriya.repository;

import me.moriya.entity.Person;
import org.slf4j.Logger;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by andre on 6/4/16.
 */
@Named
public class PersonRepository extends Repository<Person, Long> {

    private static final long serialVersionUID = -4954384505610354486L;
}