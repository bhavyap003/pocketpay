package com.bhavyap003.pocketpay.dto;

import java.math.BigDecimal;

public class CreateAccountRequest {

    private Long userId;

    private BigDecimal initialBalance;

    public CreateAccountRequest(Long userId, BigDecimal initialBalance){
        this.userId = userId;
        this.initialBalance = initialBalance;
    }

    public Long getUserId() {
        return userId;
    }

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

}
