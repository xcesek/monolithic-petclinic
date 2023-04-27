package com.ilogics.taskmgmt.command.jpacommands;

import static org.assertj.core.api.Assertions.assertThat;

import com.ilogics.taskmgmt.command.model.Person;
import com.ilogics.taskmgmt.command.model.Role;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonRepositoryIntegrationTest {

  @Autowired
  PersonRepository personRepository;

  @Test
  void findAll() {
    List<Person> persons = personRepository.findAll();

    assertThat(persons).hasSize(1);
    assertThat(persons.get(0).getId()).isEqualTo(1L);
    assertThat(persons.get(0).getTasks()).isEmpty();
  }

  @Test
  void create() {

    Person person = new Person();
    person.setName("Maria");
    person.setRole(Role.SUPERVISOR);

    personRepository.save(person);

    List<Person> persons = personRepository.findAll();
    assertThat(persons).hasSize(2);
    Person maria = persons.get(1);
    assertThat(maria.getId()).isEqualTo(2L);
    assertThat(maria.getName()).isEqualTo("Maria");
    assertThat(maria.getRole()).isEqualTo(Role.SUPERVISOR);
    assertThat(maria.getTasks()).isEmpty();

  }
}
