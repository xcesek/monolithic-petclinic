package org.springframework.samples.petclinic.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.management.dtos.TaskDTO;
import org.springframework.samples.petclinic.management.model.Employee;
import org.springframework.samples.petclinic.management.model.Instruction;
import org.springframework.samples.petclinic.management.model.Task;
import org.springframework.samples.petclinic.management.model.TaskStatus;
import org.springframework.stereotype.Service;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public void createTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setName(task.getName());
        task.setDueDate(task.getDueDate());
        task.setStatus(TaskStatus.PUBLISHED);
        Optional.ofNullable(taskDTO.getInstructions())
                .ifPresent(i -> i.forEach(ii -> {
                    Instruction instruction = new Instruction(ii);
                    instruction.setTask(task);
                    task.getInstructions().add(instruction);
                }));


//TODO::private Set<Employee> assignees;

    }
}
