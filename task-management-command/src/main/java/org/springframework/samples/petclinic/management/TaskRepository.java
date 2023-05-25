package org.springframework.samples.petclinic.management;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.management.model.Task;


public interface TaskRepository extends JpaRepository<Task, Integer> {

}
