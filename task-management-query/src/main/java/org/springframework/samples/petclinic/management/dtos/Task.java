package org.springframework.samples.petclinic.management.dtos;

import java.util.Date;
import java.util.Set;

public class Task {

    private Integer id;

    private String name;

    private Date dueDate;

    private String comment;

    private Date completionDate;

    private TaskStatus status;

    private Set<TaskAssignee> assignees;

    private boolean isOverdue;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(final Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(final String comment) {
        this.comment = comment;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(final Date completionDate) {
        this.completionDate = completionDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(final TaskStatus status) {
        this.status = status;
    }

    public Set<TaskAssignee> getAssignees() {
        return assignees;
    }

    public void setAssignees(final Set<TaskAssignee> assignees) {
        this.assignees = assignees;
    }

    public boolean isOverdue() {
        return isOverdue;
    }

    public void setOverdue(final boolean overdue) {
        isOverdue = overdue;
    }
}
