package com.ilogics.taskmgmt.command.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "team")
@Getter
@Setter
public class Team {

  @Id
  private Long id;

  private String name;

  @OneToMany
  @JoinColumn(name = "team_id")
  private List<Person> members;

  @OneToOne
  private Person supervisor;

}
