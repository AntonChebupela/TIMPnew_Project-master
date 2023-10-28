package com.company.repository;

import com.company.domain.CardAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardAccountRepository extends JpaRepository<CardAccount, Integer> {
}
