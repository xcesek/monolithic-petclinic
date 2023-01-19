package org.springframework.samples.petclinic.vets;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.samples.petclinic.vetdto.SpecialtyDto;
import org.springframework.samples.petclinic.vetdto.VetDto;
import org.springframework.stereotype.Service;

@Service
public class VetService {

  private final VetRepository vets;

  public VetService(VetRepository vets) {
    this.vets = vets;
  }

  public Collection<VetDto> allVets() {
    return this.vets.findAll().stream()
        .map(entity -> {
          VetDto vetDto = new VetDto();
          vetDto.setId(entity.getId());
          vetDto.setFirstName(entity.getFirstName());
          vetDto.setLastName(entity.getLastName());
          vetDto.setSpecialties(entity.getSpecialties().stream()
              .map(specialty -> {
                SpecialtyDto specialtyDto = new SpecialtyDto();
                specialtyDto.setId(specialty.getId());
                specialtyDto.setName(specialty.getName());
                return specialtyDto;
              })
              .collect(Collectors.toList()));
          return vetDto;
        })
        .collect(Collectors.toList());
  }

}
