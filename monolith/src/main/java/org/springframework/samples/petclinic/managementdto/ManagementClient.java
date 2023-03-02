package org.springframework.samples.petclinic.managementdto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.management.ManagementService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ManagementClient implements ManagementService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${management.url}")
    private String managementUrl;

    public List<YearlyRevenueDto> listYearlyRevenue() {
        ResponseEntity<List<YearlyRevenueDto>> yearlyRevenueResponse = restTemplate.exchange(managementUrl,
                HttpMethod.GET,
                new HttpEntity<>(null,
                        null),
                new ParameterizedTypeReference<List<YearlyRevenueDto>>() {
                });

        return yearlyRevenueResponse.getBody();
    }

    @Override
    public void registerNewRevenue(LocalDate paymentDate,
                                   Integer cost) {
        throw new UnsupportedOperationException("Not implemented.");
    }

}
