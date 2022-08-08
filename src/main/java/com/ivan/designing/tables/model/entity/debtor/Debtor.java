package com.ivan.designing.tables.model.entity.debtor;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(of={"id"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Debtor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // эти должны мне
    @OneToMany(mappedBy = "debtorChild")
    private Set<RelationshipDebtorGroupDebtor> relationshipDebtorGroupDebtorsDriven;

    // этим должен я
    @OneToMany(mappedBy = "debtorParent")
    private Set<RelationshipDebtorGroupDebtor> relationshipDebtorGroupDebtorsLeading;

    private Long clientId;

    @Enumerated(EnumType.STRING)
    private DebtorClientType clientType;

    @Column(columnDefinition = "DATE")
    private LocalDate dateOpen;

    @Column(columnDefinition = "DATE")
    private LocalDate dateClose;

}
