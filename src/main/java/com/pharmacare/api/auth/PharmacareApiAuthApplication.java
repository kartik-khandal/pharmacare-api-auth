package com.pharmacare.api.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Bootstraps the HTTP API and discovers its controllers and auto-configured security library. */
@SpringBootApplication
public class PharmacareApiAuthApplication {

    public static void main(String[] args) {
        // Spring Boot creates the application context and starts the embedded web server.
        SpringApplication.run(PharmacareApiAuthApplication.class, args);
    }
}
