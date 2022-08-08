package com.ivan.designing.tables.repository.domain;

import com.ivan.designing.tables.model.entity.domain.Employee;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>,
        JpaSpecificationExecutor<Employee> {
}
