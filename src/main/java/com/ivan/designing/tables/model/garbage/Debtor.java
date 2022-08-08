package com.ivan.designing.tables.model.garbage;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

//@Entity
@Data
public class Debtor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DebtorType debtorType;

    @ManyToMany(mappedBy = "debtors")
    private Set<GroupDebtorClients> groupDebtorClients;

    // эти должны мне
    @OneToMany(mappedBy = "debtorChild")
    private Set<RelationshipDebtorDebtor> drivenDebtors;

    // этим должен я
    @OneToMany(mappedBy = "debtorParent")
    private Set<RelationshipDebtorDebtor> leadingDebtors;

}
