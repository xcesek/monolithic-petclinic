package org.springframework.samples.petclinic.management;

import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.management.dtos.TaskDTO;
import org.springframework.samples.petclinic.management.model.Instruction;
import org.springframework.samples.petclinic.management.model.Task;
import org.springframework.samples.petclinic.management.model.TaskStatus;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

  private TaskRepository taskRepository;

  private EmployeeRepository employeeRepository;

  @Autowired
  public TaskService(TaskRepository taskRepository, EmployeeRepository employeeRepository) {
    this.taskRepository = taskRepository;
    this.employeeRepository = employeeRepository;
  }

  public void createTask(TaskDTO taskDTO) {
    Task task = new Task();
    task.setName(taskDTO.getName());
    task.setComment(taskDTO.getComment());
    task.setDueDate(taskDTO.getDueDate());
    task.setStatus(TaskStatus.PUBLISHED);
    Optional.ofNullable(taskDTO.getInstructions())
        .ifPresent(i -> i.forEach(ii -> {
          Instruction instruction = new Instruction(ii);
          instruction.setTask(task);
          task.getInstructions().add(instruction);
        }));
    task.setAssignees(taskDTO.getAssignees().stream()
        .map(employeeRepository::findById)
        .flatMap(Optional::stream)
        .collect(Collectors.toSet()));

    taskRepository.save(task);

  }
}
