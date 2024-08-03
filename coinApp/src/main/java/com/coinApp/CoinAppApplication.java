package com.coinApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.coinapp")
public class CoinAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoinAppApplication.class, args);
    }
}
