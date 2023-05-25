package org.springframework.samples.petclinic.management;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.management.model.Task;
import org.springframework.samples.petclinic.management.model.TaskStatus;

@SpringBootTest
class TaskRepositoryIntegrationTest {

  @Autowired
  private TaskRepository taskRepository;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Test
  void shouldSaveTask() {
    var task = new Task();
    task.setName("name");
    task.setDueDate(new Date());
    task.setComment("comment");
    task.setStatus(TaskStatus.PUBLISHED);
    employeeRepository.findById(2).ifPresent(id -> task.setAssignees(Set.of(id)));

    Task saved = taskRepository.save(task);

    assertThat(saved.getId()).isNotNull();
  }

}