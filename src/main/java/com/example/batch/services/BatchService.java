package com.example.batch.services;


import com.example.batch.entities.Account;
import com.example.batch.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BatchService {
    private final UserRepository userRepository;

    @Autowired
    public BatchService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void processBatch(LocalDate date) {
        Account acc = new Account();
        acc.setUsername("Chanombude");
        acc.setEmail("chanombude@gmail.com");
        acc.setCreateAt(date);

        // Process with DB
        userRepository.save(acc);

        System.out.println("== List Accounts ==");
        for (Account account : userRepository.findAll()) {
            System.out.printf("Account : %s, at : %s\n", account.getUsername(), account.getCreateAt());
        }
    }
}
