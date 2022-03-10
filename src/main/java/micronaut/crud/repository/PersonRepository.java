package micronaut.crud.repository;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import micronaut.crud.entity.Person;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface PersonRepository extends CrudRepository<Person, Long> {
}
