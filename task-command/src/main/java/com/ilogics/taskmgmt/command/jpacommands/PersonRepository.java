package com.ilogics.taskmgmt.command.jpacommands;

import com.ilogics.taskmgmt.command.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
