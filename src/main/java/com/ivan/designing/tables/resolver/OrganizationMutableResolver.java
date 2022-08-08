package com.ivan.designing.tables.resolver;

import com.ivan.designing.tables.model.entity.domain.Organization;
import com.ivan.designing.tables.model.entity.domain.OrganizationInput;
import com.ivan.designing.tables.repository.domain.OrganizationRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrganizationMutableResolver implements GraphQLMutationResolver {

    private final OrganizationRepository repository;

//    OrganizationMutableResolver(OrganizationRepository repository) {
//        this.repository = repository;
//    }

    public Organization newOrganization(OrganizationInput organizationInput) {
        return repository.save(new Organization(null, organizationInput.getName(), null, null));
    }

}
