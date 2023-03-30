package org.springframework.samples.petclinic.activemq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.samples.petclinic.management.ManagementService;
import org.springframework.stereotype.Component;

@Component
public class RevenueRegistrationConsumer {

  private static final Logger LOGGER = LoggerFactory.getLogger(RevenueRegistrationConsumer.class);

  private ObjectMapper objectMapper;

  private final ManagementService managementService;

  public RevenueRegistrationConsumer(ObjectMapper objectMapper,
      ManagementService managementService) {
    this.objectMapper = objectMapper;
    this.managementService = managementService;

    objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
  }

  @JmsListener(destination = "${management.revenues.registration-topic}")
  public void onMessage(String message) {
    try {
      LOGGER.info("Received Message: () ",  message);
      RevenueRegistration registration = objectMapper.readValue(message, RevenueRegistration.class);
      managementService.registerNewRevenue(registration.getPaymentDate(), registration.getCost());
    } catch (Exception e) {
      LOGGER.error("Received Exception : ", e);
    }
  }
}