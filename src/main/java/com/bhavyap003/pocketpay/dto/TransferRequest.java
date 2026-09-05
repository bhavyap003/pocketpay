package com.bhavyap003.pocketpay.dto;

import java.math.BigDecimal;

public class TransferRequest {

    private Long senderAccountId;
    private Long receiverAccountId;
    private BigDecimal amount;

    public TransferRequest(){
    }

    public Long getReceiverAccountId() {
        return receiverAccountId;
    }

    public Long getSenderAccountId() {
        return senderAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

}
