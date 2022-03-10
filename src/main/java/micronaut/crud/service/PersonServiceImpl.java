package micronaut.crud.service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import micronaut.crud.entity.Person;
import micronaut.crud.repository.PersonRepository;

@Singleton
@Slf4j
public class PersonServiceImpl implements PersonService {
    @Inject
    private PersonRepository personRepository;

    @Override
    public Iterable<Person> getAllPeople() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Person with id=" + id + " not found."));
    }

    @Override
    public Person addPerson(Person person) {
        log.info("Person " + person.toString() + " was added.");
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        log.info("Person " + person.toString() + " was updated.");
        return personRepository.update(person);
    }

    @Override
    public void deletePerson(Long id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            log.info("Person with id=" + id + " was deleted.");
        }
        throw new IllegalArgumentException("Person with id=" + id + " not found.");
    }
}
