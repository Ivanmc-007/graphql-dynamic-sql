package com.ivan.designing.tables.model.garbage;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

//@Entity
@Data
public class GroupDebtorClients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String groupName;

    @ManyToMany
    @JoinTable(name="RELATIONSHIP_GROUP_DEBTOR_CLIENTS_DEBTOR",
            joinColumns=
            @JoinColumn(name="group_debtor_clients_id", referencedColumnName="id"),
            inverseJoinColumns=
            @JoinColumn(name="debtor_id", referencedColumnName="id")
    )
    private Set<Debtor> debtors;

    @Column(columnDefinition = "DATE")
    private LocalDate dataOpen;

    @Column(columnDefinition = "DATE")
    private LocalDate dataChange;

    @Column(columnDefinition = "DATE")
    private LocalDate dateClose;

}
