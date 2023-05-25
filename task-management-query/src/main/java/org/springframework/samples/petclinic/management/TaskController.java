package org.springframework.samples.petclinic.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.samples.petclinic.management.dtos.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

  private final TaskService taskService;

  @Autowired
  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @GetMapping(value = "/tasks", produces = "application/json")
  @ResponseStatus(HttpStatus.CREATED)
  public List<Task> showVetList(@RequestParam int employeeId) {
    return taskService.getEmployeeTasks(employeeId);
  }
}
