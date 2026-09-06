package com.bhavyap003.pocketpay.repository;

import com.bhavyap003.pocketpay.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
