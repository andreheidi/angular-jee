package me.moriya.repository;

import me.moriya.entity.Person;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Named;

/**
 * Created by andre on 6/4/16.
 */
public class PersonRepository extends Repository<Person, Long> {
}