package com.bhavyap003.pocketpay.controller;

import com.bhavyap003.pocketpay.dto.AccountResponse;
import com.bhavyap003.pocketpay.dto.CreateAccountRequest;
import com.bhavyap003.pocketpay.model.Account;
import com.bhavyap003.pocketpay.service.AccountService;
import org.springframework.web.bind.annotation.*;


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
}
