package micronaut.crud.controller;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.inject.Inject;
import micronaut.crud.entity.Person;
import micronaut.crud.service.PersonService;

@Controller("/people")
@ExecuteOn(TaskExecutors.IO)
public class PersonController {
    @Inject
    private PersonService personService;

    @Get
    public Iterable<Person> showPeople() {
        return personService.getAllPeople();
    }

    @Get("/{id}")
    public Person showPersonById(Long id) {
        return personService.getPersonById(id);
    }

    @Post
    public Person savePerson(@Body Person person) {
        return personService.addPerson(person);
    }

    @Put
    public Person updatePerson(@Body Person person) {
        return personService.updatePerson(person);
    }

    @Delete("/{id}")
    public void deletePerson(Long id) {
        personService.deletePerson(id);
    }
}
