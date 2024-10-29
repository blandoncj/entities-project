package dao;

import entities.Person;

public class PersonDAO extends GeneralDAO<Person> {
    public PersonDAO() {
        super(Person.class, "src/resources/people.csv");
    }
}