package com.ilogics.taskmgmt.command.jpacommands;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaPersonCommandsTest {

  @Autowired
  JpaPersonCommands commands;

  @Test
  void create_savesPersonIntoDb() {

  }
}