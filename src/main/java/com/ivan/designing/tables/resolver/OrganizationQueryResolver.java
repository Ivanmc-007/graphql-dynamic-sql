package com.ivan.designing.tables.resolver;

import com.ivan.designing.tables.model.entity.domain.Organization;
import com.ivan.designing.tables.repository.domain.OrganizationRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class OrganizationQueryResolver implements GraphQLQueryResolver {

    private OrganizationRepository repository;

    OrganizationQueryResolver(OrganizationRepository repository) {
        this.repository = repository;
    }

    public Iterable<Organization> organizations() {
        return repository.findAll();
    }

    public Organization organization(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found!"));
    }
}
