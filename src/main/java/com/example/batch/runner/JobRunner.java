package com.example.batch.runner;

import com.example.batch.services.BatchService;
import com.example.batch.utils.DateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class JobRunner implements CommandLineRunner {
    private final BatchService batchService;
    @Autowired
    public JobRunner(BatchService batchService) {
        this.batchService = batchService;
    }

    @Override
    public void run(String... args) {
        System.out.println("======= Start Batch ========");

        if (args.length == 0 || args.length > 1) {
            System.out.println("=== Invalid number of parameter : require only 1 parameter ===");
            return;
        };
        if (!DateValidator.isValidDateFormat(args[0])) {
            System.out.println("=== Invalid date format : date parameter ===");
            return;
        }
        LocalDate date = LocalDate.parse(args[0]);

        // Running batch Service
        batchService.processBatch(date);
    }
}
