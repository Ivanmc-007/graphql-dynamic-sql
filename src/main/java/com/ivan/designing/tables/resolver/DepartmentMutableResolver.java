package com.ivan.designing.tables.resolver;

import com.ivan.designing.tables.model.entity.domain.Department;
import com.ivan.designing.tables.model.entity.domain.DepartmentInput;
import com.ivan.designing.tables.model.entity.domain.Organization;
import com.ivan.designing.tables.repository.domain.DepartmentRepository;
import com.ivan.designing.tables.repository.domain.OrganizationRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DepartmentMutableResolver implements GraphQLMutationResolver {

    private final DepartmentRepository departmentRepository;
    private final OrganizationRepository organizationRepository;

//    DepartmentMutableResolver(DepartmentRepository departmentRepository, OrganizationRepository organizationRepository) {
//        this.departmentRepository = departmentRepository;
//        this.organizationRepository = organizationRepository;
//    }

    public Department newDepartment(DepartmentInput departmentInput) {
        Organization organization = organizationRepository.findById(departmentInput.getOrganizationId()).get();
        return departmentRepository.save(new Department(null, departmentInput.getName(), null, organization));
    }

}
