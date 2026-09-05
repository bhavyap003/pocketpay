package com.bhavyap003.pocketpay.service;

import com.bhavyap003.pocketpay.dto.AccountResponse;
import com.bhavyap003.pocketpay.exception.AccountNotFoundException;
import com.bhavyap003.pocketpay.exception.UserNotFoundException;
import com.bhavyap003.pocketpay.model.Account;
import com.bhavyap003.pocketpay.model.User;
import com.bhavyap003.pocketpay.repository.AccountRepository;
import com.bhavyap003.pocketpay.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public AccountService(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    public AccountResponse createAccount(Long userId, BigDecimal initialBalance){

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(
                        "User not found with id: " + userId));

        Account account = new Account(initialBalance, user);

        Account savedAccount = accountRepository.save(account);

        return new AccountResponse(savedAccount.getId(), savedAccount.getBalance());
    }

    public AccountResponse getAccount(Long id){
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(
                        "Account not found with id: " + id));

        return new AccountResponse(account.getId(), account.getBalance());
    }
}
