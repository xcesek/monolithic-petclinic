package org.springframework.samples.petclinic.management;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.samples.petclinic.management.events.CreateTaskEvent;
import org.springframework.stereotype.Component;

@Component
public class TaskEventsConsumer {

  private static final Logger LOGGER = LoggerFactory.getLogger(TaskEventsConsumer.class);

  private final ObjectMapper objectMapper;

  private final TaskService taskService;

  public TaskEventsConsumer(ObjectMapper objectMapper,
                            TaskService taskService) {
    this.objectMapper = objectMapper;
    this.taskService = taskService;

    objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
  }

  @JmsListener(destination = "${management.tasks.topic}")
  public void onMessage(String message) {
    try {
      LOGGER.info("Received Message: () ",  message);
      CreateTaskEvent createTaskEvent = objectMapper.readValue(message, CreateTaskEvent.class);
      taskService.createTask(createTaskEvent);
    } catch (Exception e) {
      LOGGER.error("Received Exception : ", e);
    }
  }
}
