package org.springframework.samples.petclinic.management;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.samples.petclinic.management.dtos.Task;
import org.springframework.samples.petclinic.management.dtos.TaskStatus;
import org.springframework.samples.petclinic.management.events.CreateTaskEvent;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Task> getEmployeeTasks(int employeeId) {
        String sql = "SELECT * FROM tasks t left join assignment a on a.task_id = t.id where a.employee_id =" + employeeId;

        return jdbcTemplate.query(sql,
                (resultSet,
                 rowNumber) -> {
                    Task task = new Task();
                    task.setName(resultSet.getString("name"));
                    task.setId(resultSet.getInt("id"));
                    task.setComment(resultSet.getString("comment"));
                    task.setDueDate(resultSet.getDate("due_date"));
                    task.setStatus(TaskStatus.valueOf(resultSet.getString("status")));
                    return task;
                });
    }

    public void createTask(CreateTaskEvent dto) {
        String sql = String.format("insert into tasks (id, comment, due_date, name, status) " + "values (%d, '%s', '%s', '%s', '%s')",
                dto.getId(),
                dto.getComment(),
                new SimpleDateFormat("yyyy-MM-dd").format(dto.getDueDate()),
                dto.getName(),
                dto.getStatus());

        jdbcTemplate.execute(sql);

        dto.getAssignees()
                .forEach(v -> jdbcTemplate.execute(String.format("insert into assignment (task_id, employee_id) values (%d, %d)",
                        dto.getId(),
                        v.getId())));
    }

}
