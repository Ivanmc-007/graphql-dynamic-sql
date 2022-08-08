package com.ivan.designing.tables.repository.garbage;

import com.ivan.designing.tables.model.garbage.GroupDebtorClients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupDebtorClientsRepository {//extends JpaRepository<GroupDebtorClients, Long> {

    Optional<GroupDebtorClients> findById(Long id);

    Optional<GroupDebtorClients> findByGroupName(String groupName);

}
