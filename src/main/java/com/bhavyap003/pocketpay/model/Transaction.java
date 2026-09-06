package com.bhavyap003.pocketpay.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_account_id", nullable = false)
    private Account sender;

    @ManyToOne
    @JoinColumn(name = "receiver_account_id", nullable = false)

    private Account receiver;
    private BigDecimal amount;
    private LocalDateTime createdAt;

    protected Transaction(){

    }

    public Transaction(Account sender, Account receiver, BigDecimal amount, LocalDateTime createdAt){
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Account getSender() {
        return sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public BigDecimal getAmount() {
        return amount;
    }

}
