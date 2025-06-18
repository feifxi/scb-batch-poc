package com.example.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BatchApplication {
	public static void main(String[] args) {
		SpringApplication.run(BatchApplication.class, args);
	}
}


// Dev run by maven
// .\mvnw.cmd spring-boot:run -D"spring-boot.run.arguments=inputDate=2025-06-18"

// Building run :
// java -jar myapp.jar inputDate=2025-06-18
