package org.springframework.samples.petclinic.managementdto;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.samples.petclinic.management.ManagementService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Primary
@Service
public class ManagementClient implements ManagementService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JmsTemplate jmsTemplate;

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
        final Map<String, Object> message = new HashMap<>();
        message.put("paymentDate", paymentDate.toEpochDay());
        message.put("cost", cost);

        jmsTemplate.convertAndSend("visitCreated", message);

    }

}
