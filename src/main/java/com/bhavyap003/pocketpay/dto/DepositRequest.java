package com.bhavyap003.pocketpay.dto;

import java.math.BigDecimal;

public class DepositRequest {

    private BigDecimal amount;

    public DepositRequest(){

    }

    public BigDecimal getAmount(){
        return amount;
    }
}
