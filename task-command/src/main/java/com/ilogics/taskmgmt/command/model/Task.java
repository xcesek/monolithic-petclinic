package com.ilogics.taskmgmt.command.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "task")
@Getter
@Setter
public class Task {

  @Id
  private Long id;

  private String name;

  @Enumerated(EnumType.STRING)
  private Status status;

  private String instructions;

  private Date dueDate;

  private Date completionDate;

  private String completionComment;

}
