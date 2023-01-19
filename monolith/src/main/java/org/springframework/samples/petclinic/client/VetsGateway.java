package org.springframework.samples.petclinic.client;

import org.springframework.samples.petclinic.vetdto.VetDto;

import java.util.Collection;

public interface VetsGateway {
    Collection<VetDto> allVets();
}
