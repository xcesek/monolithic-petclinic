package org.springframework.samples.petclinic.management;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.management.dtos.TaskDTO;
import org.springframework.samples.petclinic.management.model.Employee;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private Publisher publisher;

    TaskService taskService;

    @BeforeEach
    void prepare() {
        taskService = new TaskService(taskRepository,
                employeeRepository,
                publisher);
    }

    @Test
    void shouldCreateTask() {
        var taskDTO = new TaskDTO();
        taskDTO.setName("name");
        taskDTO.setDueDate(new Date());
        taskDTO.setComment("comment");
        taskDTO.setAssignees(Set.of(1,
                2));

        when(employeeRepository.findById(1)).thenReturn(Optional.of(prepareEmployee(1)));
        when(employeeRepository.findById(2)).thenReturn(Optional.of(prepareEmployee(2)));

        taskService.createTask(taskDTO);

        verify(taskRepository).save(any());
    }

    private Employee prepareEmployee(int id) {
        var employee = new Employee();
        employee.setId(id);
        return employee;
    }

}
