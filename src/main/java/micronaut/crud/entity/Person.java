package micronaut.crud.entity;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import lombok.Data;

@MappedEntity
@Data
public class Person {
    @Id
    @GeneratedValue(GeneratedValue.Type.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
}
