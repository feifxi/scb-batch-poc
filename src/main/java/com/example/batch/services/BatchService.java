package com.example.batch.services;


import com.example.batch.entities.User;
import com.example.batch.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BatchService {
    private final UserRepository userRepository;

    @Value("${DB_URL:localhost:3306}")
    private String INJECT_DB_URL;

    @Autowired
    public BatchService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void processBatch(LocalDate date) {
        System.out.println("✅ Running job for date: " + date);

        // Checking ENV
        String DB_URL = System.getenv("DB_URL");
        System.out.println("DB_RL ENV: " + DB_URL);

        System.out.println("INJECTED DB_URL ENV: " + INJECT_DB_URL);

        User user1 = new User();
        user1.setName("Fei");
        user1.setEmail("example" + date + "@gmail.com");
        User user2 = new User();
        user2.setName("Ter");
        user2.setEmail("example" + date + "@gmail.com");
        User user3 = new User();
        user3.setName("CD");
        user3.setEmail("example" + date + "@gmail.com");

        // Process with DB
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        for (User u : userRepository.findAll()) {
            System.out.println("User : " + u.getName());
        }
    }
}
