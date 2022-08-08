package com.ivan.designing.tables.repository.client;

import com.ivan.designing.tables.model.entity.temp.Client;
import com.ivan.designing.tables.model.entity.temp.ClientGetDTO;
import com.ivan.designing.tables.model.entity.temp.Client_;
import com.ivan.designing.tables.model.entity.temp.ContactEmailGetDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ClientDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ClientGetDTO> findById(Long id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
        // из какой сущности мы хотим получить результат
        Root<Client> employeeRoot = criteriaQuery.from(Client.class);
        // Создаём предикат, который будет фильтровать наш результат
        Predicate predicate = this.getPredicate(id, employeeRoot, criteriaBuilder);
        criteriaQuery.where(predicate);
        TypedQuery<Client> typedQuery = entityManager.createQuery(criteriaQuery);
        List<ClientGetDTO> clients = typedQuery.getResultList().stream()
                .map(client ->
                        ClientGetDTO.builder()
                                .clientId(client.getClientId())
                                .clientName(client.getClientName())
                                .contactEmails(client.getContactEmails().stream()
                                        .map(contactEmail -> ContactEmailGetDTO.builder()
                                                .id(contactEmail.getId())
                                                .email(contactEmail.getEmail())
                                                .typeEmail(contactEmail.getTypeEmail())
                                                .build())
                                        .collect(Collectors.toList()))
                                .build())
                .collect(Collectors.toList());
        return clients;
    }

    private Predicate getPredicate(Long id,
                                   Root<Client> root, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(
                criteriaBuilder.equal(
                        root.get(Client_.CLIENT_ID), id.toString()
                )
        );
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

}
