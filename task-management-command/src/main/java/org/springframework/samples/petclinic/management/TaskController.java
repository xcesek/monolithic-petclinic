package org.springframework.samples.petclinic.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.samples.petclinic.management.dtos.TaskDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TaskController {

  private TaskService taskService;

  @Autowired
  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @PostMapping(value = "/tasks", consumes = "application/json", produces = "application/json")
  @ResponseStatus(HttpStatus.CREATED)
  public void showVetList(@RequestBody TaskDTO taskDTO) {
    taskService.createTask(taskDTO);
  }
}
