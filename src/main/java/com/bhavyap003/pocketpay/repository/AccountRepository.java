package com.bhavyap003.pocketpay.repository;

import com.bhavyap003.pocketpay.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
