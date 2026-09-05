package com.bhavyap003.pocketpay.dto;

import java.math.BigDecimal;

public class WithdrawRequest {

    private BigDecimal amount;

    public WithdrawRequest(){
    }

    public BigDecimal getAmount(){
        return amount;
    }
}
