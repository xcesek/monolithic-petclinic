package com.ilogics.taskmgmt.command.jpacommands;

import com.ilogics.taskmgmt.command.model.Person;
import com.ilogics.taskmgmt.command.model.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaPersonCommandsTest {

  @Autowired
  JpaPersonCommands commands;

  @Test
  void create_savesPersonIntoDb() {

    Person person = new Person();
    person.setName("Maria");
    person.setRole(Role.SUPERVISOR);

    commands.create(person);
  }
}