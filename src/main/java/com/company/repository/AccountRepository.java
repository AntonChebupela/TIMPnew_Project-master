package com.company.repository;

import com.company.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findById(int id);

    Account findByAccount(String name);
}
