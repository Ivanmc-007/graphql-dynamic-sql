package com.ivan.designing.tables.model.entity.debtor;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Builder
@EqualsAndHashCode(of={"id"})
@NoArgsConstructor
@AllArgsConstructor
public class DebtorGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String groupName;

    @OneToMany(mappedBy = "debtorGroup")
    private Set<RelationshipDebtorGroupDebtor> debtors;

    @Column(columnDefinition = "DATE")
    private LocalDate dateOpen;

    @Column(columnDefinition = "DATE")
    private LocalDate dateChange;

    @Column(columnDefinition = "DATE")
    private LocalDate dateClose;

}
