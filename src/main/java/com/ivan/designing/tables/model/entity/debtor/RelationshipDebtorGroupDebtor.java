package com.ivan.designing.tables.model.entity.debtor;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@EqualsAndHashCode(of={"id"})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RelationshipDebtorGroupDebtor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "debtor_group_id")
    private DebtorGroup debtorGroup;

    @ManyToOne
    @JoinColumn(name = "debtor_parent_id")
    private Debtor debtorParent;

    @ManyToOne
    @JoinColumn(name = "debtor_child_id")
    private Debtor debtorChild;

    private String typeRelCode;

    private String note;

    private BigDecimal percentRel;

    @Column(columnDefinition = "DATE")
    private LocalDate dateOpen;

    private LocalDate dateClose;

}
