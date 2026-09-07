package com.bhavyap003.pocketpay.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionResponse {

    private Long id;
    private Long senderAccountId;
    private Long receiverAccountId;
    private BigDecimal amount;
    private LocalDateTime createdAt;

    protected TransactionResponse(){
    }

    public TransactionResponse(Long id,
                               Long senderAccountId,
                               Long receiverAccountId,
                               BigDecimal amount,
                               LocalDateTime createdAt){

        this.id = id;
        this.senderAccountId = senderAccountId;
        this.receiverAccountId = receiverAccountId;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    public Long getReceiverAccountId() {
        return receiverAccountId;
    }

    public Long getId() {
        return id;
    }

    public Long getSenderAccountId() {
        return senderAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}
