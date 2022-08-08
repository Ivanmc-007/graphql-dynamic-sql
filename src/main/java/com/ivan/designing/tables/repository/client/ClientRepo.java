package com.ivan.designing.tables.repository.client;

import com.ivan.designing.tables.model.entity.temp.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

    <T> List<T> findAllByClientIdIn(List<Long> ids);

}
