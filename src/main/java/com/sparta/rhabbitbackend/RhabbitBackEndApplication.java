package com.sparta.rhabbitbackend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableJpaAuditing
//@EnableBatchProcessing
@SpringBootApplication
public class RhabbitBackEndApplication {

    public static void main(String[] args) {

        SpringApplication.run(RhabbitBackEndApplication.class, args);
    }

}
