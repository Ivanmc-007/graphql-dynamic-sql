package com.ivan.designing.tables.resolver;

import com.ivan.designing.tables.filter.EmployeeFilter;
import com.ivan.designing.tables.filter.FilterField;
import com.ivan.designing.tables.model.entity.domain.Employee;
import com.ivan.designing.tables.repository.domain.EmployeeRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class EmployeeQueryResolver implements GraphQLQueryResolver {

    private EmployeeRepository repository;

    EmployeeQueryResolver(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Iterable<Employee> employees() {
        return repository.findAll();
    }

    public Employee employee(Integer id) {
        return repository.findById(id).get();
    }

    public Iterable<Employee> employeesWithFilter(EmployeeFilter filter) {
        Specification<Employee> spec = null;
        if (filter.getSalary() != null)
            spec = bySalary(filter.getSalary());
        if (filter.getAge() != null)
            spec = (spec == null ? byAge(filter.getAge()) : spec.and(byAge(filter.getAge())));
        if (filter.getPosition() != null)
            spec = (spec == null ? byPosition(filter.getPosition()) :
                    spec.and(byPosition(filter.getPosition())));
        if (spec != null)
            return repository.findAll(spec);
        else
            return repository.findAll();
    }

    private Specification<Employee> bySalary(FilterField filterField) {
        return (Specification<Employee>) (root, query, builder) -> filterField.generateCriteria(builder, root.get("salary"));
    }

    private Specification<Employee> byAge(FilterField filterField) {
        return (Specification<Employee>) (root, query, builder) -> filterField.generateCriteria(builder, root.get("age"));
    }

    private Specification<Employee> byPosition(FilterField filterField) {
        return (Specification<Employee>) (root, query, builder) -> filterField.generateCriteria(builder, root.get("position"));
    }
}
