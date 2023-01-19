package org.springframework.samples.petclinic.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.vetdto.VetDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;

@Service
public class VetClient implements VetsGateway {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${vets.url}")
    private String vetsUrl;

    public Collection<VetDto> allVets() {
        ResponseEntity<List<VetDto>> vetsResponse = restTemplate.exchange(vetsUrl,
                HttpMethod.GET,
                new HttpEntity<>(null, null),
                new ParameterizedTypeReference<List<VetDto>>() {
                });

        return vetsResponse.getBody();
    }
}
