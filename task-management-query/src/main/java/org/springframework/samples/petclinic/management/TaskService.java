package org.springframework.samples.petclinic.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.samples.petclinic.management.dtos.Task;
import org.springframework.samples.petclinic.management.dtos.TaskStatus;
import org.springframework.samples.petclinic.management.events.CreateTaskEvent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Task> getEmployeeTasks(int employeeId) {
        String sql = "SELECT * FROM tasks";

        return jdbcTemplate.query(sql, (resultSet, rowNumber) -> {
                    Task task = new Task();
                    task.setName(resultSet.getString("name"));
                    task.setId(resultSet.getInt("id"));
                    task.setComment(resultSet.getString("comment"));
                    task.setDueDate(resultSet.getDate("due_date"));
                    task.setStatus(TaskStatus.valueOf(resultSet.getString("status")));
                    return task;
                });
    }

    public void createTask(CreateTaskEvent createTaskEvent) {


    }

}
