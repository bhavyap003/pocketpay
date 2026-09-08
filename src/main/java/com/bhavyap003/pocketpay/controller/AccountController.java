package com.bhavyap003.pocketpay.controller;

import com.bhavyap003.pocketpay.dto.*;
import com.bhavyap003.pocketpay.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping
    public AccountResponse createAccount(@RequestBody CreateAccountRequest request){
        return accountService.createAccount(request.getUserId(), request.getInitialBalance());
    }

    @GetMapping("/{id}")
    public AccountResponse getAccount(@PathVariable Long id){
        return accountService.getAccount(id);
    }

    @PostMapping("/{id}/deposit")
    public AccountResponse deposit(@PathVariable Long id, @RequestBody DepositRequest request){
        return accountService.deposit(id, request.getAmount());
    }

    @PostMapping("/{id}/withdraw")
    public AccountResponse withdraw(@PathVariable Long id, @RequestBody WithdrawRequest request){
        return accountService.withdraw(id, request.getAmount());
    }

    @PostMapping("/transfer")
    public TransferResponse transfer(@RequestBody TransferRequest request){

        return accountService.transfer(request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount());
    }

}

