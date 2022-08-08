package com.ivan.designing.tables.repository.debtor;

import com.ivan.designing.tables.model.entity.debtor.DebtorGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebtorGroupRepository extends JpaRepository<DebtorGroup,Long> {
}
