package org.springframework.samples.petclinic.management.events;

import org.springframework.samples.petclinic.management.model.TaskStatus;

import java.util.Date;
import java.util.Set;

public class CreateTaskEvent {
    private Integer id;

    private String name;

    private Date dueDate;

    private String comment;

    private Date completionDate;

    private TaskStatus status;

    private Set<String> instructions;

    private Set<Integer> assignees;

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

    public Set<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(final Set<String> instructions) {
        this.instructions = instructions;
    }

    public Set<Integer> getAssignees() {
        return assignees;
    }

    public void setAssignees(final Set<Integer> assignees) {
        this.assignees = assignees;
    }
}
