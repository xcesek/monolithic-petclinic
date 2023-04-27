package org.springframework.samples.petclinic.management.events;

import java.util.Date;

public class PostponeTaskEvent {
    private Integer id;

    private Date dueDate;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(final Date dueDate) {
        this.dueDate = dueDate;
    }
}
