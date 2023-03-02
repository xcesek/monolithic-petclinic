package org.springframework.samples.petclinic.vet;

import org.springframework.samples.petclinic.vet.VetDto;

import java.util.Collection;

public interface VetsGateway {
    Collection<VetDto> allVets();
}
