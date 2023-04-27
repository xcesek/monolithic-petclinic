package org.springframework.samples.petclinic.management;

import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.management.model.Task;


public interface TaskRepository extends Repository<Task, Integer> {

}
