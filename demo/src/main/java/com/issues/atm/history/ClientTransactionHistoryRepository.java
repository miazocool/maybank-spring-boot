package com.issues.atm.history;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientTransactionHistoryRepository extends JpaRepository<ClientTransactionHistory, Long> {
}