package com.bhavyap003.pocketpay.controller;

import com.bhavyap003.pocketpay.dto.TransactionResponse;
import com.bhavyap003.pocketpay.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final AccountService accountService;

    public TransactionController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping("/account/{accountId}")
    public List<TransactionResponse> getTransactions(@PathVariable Long accountId){
        return accountService.getTransactions(accountId);
    }

    @GetMapping("/{transactionId}")
    public TransactionResponse getTransaction(@PathVariable Long transactionId){
        return accountService.getTransaction(transactionId);
    }
}
