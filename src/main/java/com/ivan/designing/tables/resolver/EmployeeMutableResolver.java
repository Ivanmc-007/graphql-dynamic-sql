package com.ivan.designing.tables.resolver;

import com.ivan.designing.tables.model.entity.domain.Department;
import com.ivan.designing.tables.model.entity.domain.Employee;
import com.ivan.designing.tables.model.entity.domain.EmployeeInput;
import com.ivan.designing.tables.model.entity.domain.Organization;
import com.ivan.designing.tables.repository.domain.DepartmentRepository;
import com.ivan.designing.tables.repository.domain.EmployeeRepository;
import com.ivan.designing.tables.repository.domain.OrganizationRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMutableResolver implements GraphQLMutationResolver {

    DepartmentRepository departmentRepository;
    EmployeeRepository employeeRepository;
    OrganizationRepository organizationRepository;

    EmployeeMutableResolver(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, OrganizationRepository organizationRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.organizationRepository = organizationRepository;
    }

    public Employee newEmployee(EmployeeInput employeeInput) {
        Department department = departmentRepository.findById(employeeInput.getDepartmentId()).get();
        Organization organization = organizationRepository.findById(employeeInput.getOrganizationId()).get();
        return employeeRepository.save(new Employee(null, employeeInput.getFirstName(), employeeInput.getLastName(),
                employeeInput.getPosition(), employeeInput.getAge(), employeeInput.getSalary(),
                department, organization));
    }

}
