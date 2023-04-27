package com.ilogics.taskmgmt.command.jpacommands;

import com.ilogics.taskmgmt.command.commands.PersonCommands;
import com.ilogics.taskmgmt.command.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class JpaPersonCommands implements PersonCommands {

  private PersonRepository repository;

  @Autowired
  public JpaPersonCommands(PersonRepository repository) {
    this.repository = repository;
  }

  @Override
  @Transactional
  public void create(Person person) {

    repository.save(person);
  }
}
