package com.bhavyap003.pocketpay.repository;

import com.bhavyap003.pocketpay.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
}
