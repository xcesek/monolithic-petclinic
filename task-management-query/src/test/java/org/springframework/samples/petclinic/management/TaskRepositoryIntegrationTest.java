package org.springframework.samples.petclinic.management;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TaskRepositoryIntegrationTest {

    @Autowired
    private TaskService taskService;


    @Test
    void getTaskShouldReturnData() {
        var result = taskService.getEmployeeTasks(1);

        assertThat(result).isNotEmpty();

    }



}
