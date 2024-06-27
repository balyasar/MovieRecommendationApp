package com.yasar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AuthMicroServiceApp {
    public static void main(String[] args) {
    SpringApplication.run(AuthMicroServiceApp.class);

    }
}
