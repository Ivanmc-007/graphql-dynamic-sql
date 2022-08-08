package com.ivan.designing.tables.repository.debtor;

import com.ivan.designing.tables.model.entity.debtor.Debtor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebtorRepository extends JpaRepository<Debtor,Long> {
}
