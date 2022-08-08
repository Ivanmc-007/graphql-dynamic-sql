package com.ivan.designing.tables;

import com.ivan.designing.tables.model.entity.debtor.Debtor;
import com.ivan.designing.tables.model.entity.debtor.DebtorClientType;
import com.ivan.designing.tables.model.entity.debtor.DebtorGroup;
import com.ivan.designing.tables.model.entity.debtor.RelationshipDebtorGroupDebtor;
import com.ivan.designing.tables.repository.debtor.DebtorGroupRepository;
import com.ivan.designing.tables.repository.debtor.DebtorRepository;
import com.ivan.designing.tables.repository.debtor.RelationshipDebtorGroupDebtorRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.stream.Stream;

@SpringBootApplication
@Log4j2
public class Application {

	@Autowired
	private DebtorRepository debtorRepository;

	@Autowired
	private RelationshipDebtorGroupDebtorRepository relationshipDebtorGroupDebtorRepository;

	@Autowired
	private DebtorGroupRepository debtorGroupRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	ApplicationRunner init(DebtorRepository debtorRepository) {
		return args -> {
			Debtor parent = Debtor.builder()
					.clientId(393L)
					.dateOpen(LocalDate.now())
					.clientType(DebtorClientType.CORP)
					.build();

			Debtor child = Debtor.builder()
					.clientId(262L)
					.dateOpen(LocalDate.now())
					.clientType(DebtorClientType.CORP)
					.build();

			Debtor child2 = Debtor.builder()
					.clientId(121L)
					.dateOpen(LocalDate.now())
					.clientType(DebtorClientType.CORP)
					.build();

			parent = debtorRepository.saveAndFlush(parent);
			child = debtorRepository.saveAndFlush(child);
			child2 = debtorRepository.saveAndFlush(child2);

			DebtorGroup debtorGroup = DebtorGroup.builder()
					.dateOpen(LocalDate.now())
					.groupName("Common group")
					.build();

			debtorGroup = debtorGroupRepository.save(debtorGroup);

			RelationshipDebtorGroupDebtor relationshipDebtorGroupDebtor = RelationshipDebtorGroupDebtor.builder()
					.dateOpen(LocalDate.now())
					.debtorParent(parent)
					.debtorChild(child)
					.debtorGroup(debtorGroup)
					.typeRelCode("11")
					.build();

			RelationshipDebtorGroupDebtor relationshipDebtorGroupDebtor2 = RelationshipDebtorGroupDebtor.builder()
					.dateOpen(LocalDate.now())
					.debtorParent(parent)
					.debtorChild(child2)
					.debtorGroup(debtorGroup)
					.typeRelCode("12")
					.build();

//			Stream.of(parent,child).forEach(debtor -> {
//				Debtor res = debtorRepository.saveAndFlush(debtor);
//				log.info("debtorId: " + res.getId());
//			});

			relationshipDebtorGroupDebtorRepository.saveAndFlush(relationshipDebtorGroupDebtor);
			relationshipDebtorGroupDebtorRepository.saveAndFlush(relationshipDebtorGroupDebtor2);

		};
	}

}
