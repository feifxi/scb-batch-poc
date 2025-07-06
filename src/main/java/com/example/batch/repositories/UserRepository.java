package com.example.batch.repositories;

import com.example.batch.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<Account, Long>  {
    @Query("SELECT a FROM Account a")
    List<Account> findAllAccounts();
}