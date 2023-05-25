package org.springframework.samples.petclinic.management;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.samples.petclinic.management.model.Task;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

  private static final Logger LOGGER = LoggerFactory.getLogger(Publisher.class);


  private ObjectMapper objectMapper;

  private JmsTemplate jmsTemplate;

  @Value("${management.tasks.topic}")
  private String topic;

  @Autowired
  public Publisher(JmsTemplate jmsTemplate) {
    this.jmsTemplate = jmsTemplate;

    objectMapper = new ObjectMapper();

    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
  }

  public void sendMessage(Task task) {
    try {
      String data = objectMapper.writeValueAsString(task);
      jmsTemplate.convertAndSend(topic, data);
      LOGGER.info("Message sent!");
    } catch (Exception e) {
      LOGGER.error("Recieved Exception during send Message: ", e);
    }
  }

}
