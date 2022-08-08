package com.ivan.designing.tables.model.garbage;

import lombok.Data;

import javax.persistence.*;

//@Entity
@Data
public class RelationshipDebtorDebtor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "debtor_parent_id")
    private Debtor debtorParent;

    @ManyToOne
    @JoinColumn(name = "debtor_child_id")
    private Debtor debtorChild;

    private String code;

}
