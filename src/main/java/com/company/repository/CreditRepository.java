package com.company.repository;

import com.company.domain.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit, Integer> {

    Credit findCreditByClientName(String name);

}
