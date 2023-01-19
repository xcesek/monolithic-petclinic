package org.springframework.samples.petclinic.vetdto;

import java.util.List;

public class VetDto {

  private Integer id;

  private String firstName;

  private String lastName;

  private List<SpecialtyDto> specialties;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public List<SpecialtyDto> getSpecialties() {
    return specialties;
  }

  public void setSpecialties(
      List<SpecialtyDto> specialties) {
    this.specialties = specialties;
  }
}
