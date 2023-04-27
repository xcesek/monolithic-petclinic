package org.springframework.samples.petclinic.management.events;

public class CancelTaskEvent {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }
}
