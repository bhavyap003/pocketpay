package com.bhavyap003.pocketpay.dto;

import java.math.BigDecimal;

public class TransferResponse {

    private String message;
    private Long senderAccountId;
    private Long receiverAccountId;
    private BigDecimal amount;

    public TransferResponse(String message, Long senderAccountId, Long receiverAccountId, BigDecimal amount) {
        this.message = message;
        this.senderAccountId = senderAccountId;
        this.receiverAccountId = receiverAccountId;
        this.amount = amount;
    }

    public Long getSenderAccountId() {
        return senderAccountId;
    }

    public String getMessage() {
        return message;
    }

    public Long getReceiverAccountId() {
        return receiverAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}

