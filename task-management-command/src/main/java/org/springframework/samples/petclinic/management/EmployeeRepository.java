package org.springframework.samples.petclinic.management;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.management.model.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Transactional(readOnly = true)
    Collection<Employee> findEmployeesBySupervisorId(final Integer id) throws DataAccessException;
}
