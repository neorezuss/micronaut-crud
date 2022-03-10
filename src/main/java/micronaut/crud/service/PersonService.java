package micronaut.crud.service;

import micronaut.crud.entity.Person;

public interface PersonService {
    Iterable<Person> getAllPeople();

    Person getPersonById(Long id);

    Person addPerson(Person person);

    Person updatePerson(Person person);

    void deletePerson(Long id);
}