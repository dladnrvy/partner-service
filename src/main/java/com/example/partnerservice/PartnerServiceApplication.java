package com.example.partnerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PartnerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PartnerServiceApplication.class, args);
    }

}
