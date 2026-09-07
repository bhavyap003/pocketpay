package com.bhavyap003.pocketpay.repository;

import com.bhavyap003.pocketpay.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findBySender_IdOrReceiver_Id(Long senderAccountId, Long receiverAccountId);
}
