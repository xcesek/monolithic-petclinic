package com.ilogics.taskmgmt.command.jpacommands;

import static org.assertj.core.api.Assertions.assertThat;

import com.ilogics.taskmgmt.command.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonRepositoryIntegrationTest {

  @Autowired
  PersonRepository personRepository;

  @Test
  void testFindVets() {
    Iterable<Person> all = personRepository.findAll();
    assertThat(all).hasSize(1);
  }
}
