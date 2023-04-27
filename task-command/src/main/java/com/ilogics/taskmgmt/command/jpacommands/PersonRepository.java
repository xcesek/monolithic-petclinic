package com.ilogics.taskmgmt.command.jpacommands;

import com.ilogics.taskmgmt.command.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}
