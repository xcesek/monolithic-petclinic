package org.springframework.samples.petclinic.vets;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.vetdto.VetDto;

@SpringBootTest
class VetServiceTest {

  @Autowired
  VetService service;

  @Test
  void shouldFindVets() {
    Collection<VetDto> vets = service.allVets();

    assertThat(vets)
        .filteredOn(vet -> vet.getId() == 3)
        .hasSize(1)
        .first()
        .hasFieldOrPropertyWithValue("lastName", "Douglas")
        .extracting(VetDto::getSpecialties).asList()
        .hasSize(2)
        .extracting("name")
        .containsExactly("dentistry", "surgery");
  }
}