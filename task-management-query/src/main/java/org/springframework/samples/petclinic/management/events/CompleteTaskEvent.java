package org.springframework.samples.petclinic.management.events;

import java.util.Date;

public class CompleteTaskEvent {
    private Integer id;

    private String comment;

    private Date completionDate;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
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
}
