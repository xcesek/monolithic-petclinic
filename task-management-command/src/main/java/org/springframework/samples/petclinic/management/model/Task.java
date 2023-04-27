package org.springframework.samples.petclinic.management.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tasks")
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    @NotEmpty
    private String name;

    @Column(name = "due_date")
    @NotEmpty
    private Date dueDate;

    @Column(name = "comment")
    private String comment;

    @Column(name = "completion_date")
    private Date completionDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    @NotNull
    private TaskStatus status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "task")
    private Set<Instruction> instructions;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "assignment", joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private Set<Employee> assignees;

    public Task() {
        super();
        this.instructions = new HashSet<>();
        this.assignees = new HashSet<>();
    }

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

    public Set<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(final Set<Instruction> instructions) {
        this.instructions = instructions;
    }

    public Set<Employee> getAssignees() {
        return assignees;
    }

    public void setAssignees(final Set<Employee> assignees) {
        this.assignees = assignees;
    }
}
