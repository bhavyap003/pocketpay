package com.bhavyap003.pocketpay.service;

import com.bhavyap003.pocketpay.dto.AccountResponse;
import com.bhavyap003.pocketpay.dto.TransactionResponse;
import com.bhavyap003.pocketpay.dto.TransferResponse;
import com.bhavyap003.pocketpay.exception.*;
import com.bhavyap003.pocketpay.model.Account;
import com.bhavyap003.pocketpay.model.Transaction;
import com.bhavyap003.pocketpay.model.User;
import com.bhavyap003.pocketpay.repository.AccountRepository;
import com.bhavyap003.pocketpay.repository.TransactionRepository;
import com.bhavyap003.pocketpay.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public AccountService(UserRepository userRepository, AccountRepository accountRepository,
                          TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
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

    public AccountResponse deposit(Long accountId, BigDecimal amount){
        if(amount.compareTo(BigDecimal.ZERO) <= 0){
            throw new InvalidAmountException("Amount must be greater than zero");
        }

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException(
                        "Account not found with id: " + accountId));

        BigDecimal newBalance = account.getBalance().add(amount);

        account.setBalance(newBalance);

        Account savedAccount = accountRepository.save(account);

        return new AccountResponse(savedAccount.getId(), savedAccount.getBalance());
    }

    public AccountResponse withdraw(Long accountId, BigDecimal amount){
        if(amount.compareTo(BigDecimal.ZERO) <= 0){
            throw new InvalidAmountException("Amount must be greater than zero");
        }

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException(
                        "Account not found with id: " + accountId));

        if(account.getBalance().compareTo(amount) < 0){
            throw new InsufficientBalanceException("Account balance is insufficient");
        }

        BigDecimal newBalance = account.getBalance().subtract(amount);

        account.setBalance(newBalance);

        Account savedAccount = accountRepository.save(account);

        return new AccountResponse(savedAccount.getId(), savedAccount.getBalance());
    }

    @Transactional
    public TransferResponse transfer(Long senderAccountId, Long receiverAccountId, BigDecimal amount){
        if(senderAccountId.equals(receiverAccountId)){
            throw new InvalidTransferException("Sender and receiver accounts must be different");
        }
        if(amount.compareTo(BigDecimal.ZERO) <= 0){
            throw new InvalidAmountException("Amount must be greater than zero");
        }
        Account sender = accountRepository.findById(senderAccountId)
                .orElseThrow(() -> new AccountNotFoundException(
                        "Sender account not found with id: " + senderAccountId));

        Account receiver = accountRepository.findById(receiverAccountId)
                .orElseThrow(() -> new AccountNotFoundException(
                        "Receiver account not found with id: " + receiverAccountId));

        if(sender.getBalance().compareTo(amount) < 0){
            throw new InsufficientBalanceException("Account balance is insufficient");
        }

        BigDecimal newSenderBalance = sender.getBalance().subtract(amount);

        BigDecimal newReceiverBalance = receiver.getBalance().add(amount);

        sender.setBalance(newSenderBalance);
        receiver.setBalance(newReceiverBalance);

//        accountRepository.save(sender);
//        accountRepository.save(receiver);

        Transaction transaction = new Transaction(sender, receiver, amount, LocalDateTime.now());
        transactionRepository.save(transaction);

        return new TransferResponse(
                "Transfer successful",
                senderAccountId,
                receiverAccountId,
                amount);
    }

    public List<TransactionResponse> getTransactions(Long accountId){
        List<Transaction> transactions = transactionRepository.findBySender_IdOrReceiver_Id(accountId, accountId);

        List<TransactionResponse> responses = new ArrayList<>();

        for(Transaction transaction : transactions){
            TransactionResponse response = new TransactionResponse(
                    transaction.getId(),
                    transaction.getSender().getId(),
                    transaction.getReceiver().getId(),
                    transaction.getAmount(),
                    transaction.getCreatedAt()
            );
            responses.add(response);
        }
        return responses;
    }

    public TransactionResponse getTransaction(Long transactionId){
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new TransactionNotFoundException(
                        "Transaction not found with id: " + transactionId));

        return new TransactionResponse(
                transaction.getId(),
                transaction.getSender().getId(),
                transaction.getReceiver().getId(),
                transaction.getAmount(),
                transaction.getCreatedAt());

    }
}
