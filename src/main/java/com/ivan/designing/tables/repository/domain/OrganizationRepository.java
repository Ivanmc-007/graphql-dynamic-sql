package com.ivan.designing.tables.repository.domain;

import com.ivan.designing.tables.model.entity.domain.Organization;
import org.springframework.data.repository.CrudRepository;

public interface OrganizationRepository extends CrudRepository<Organization, Integer> {
}
