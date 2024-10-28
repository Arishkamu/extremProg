package org.ruletka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RouletteApplication {

    public static void main(String[] args) {
        SpringApplication.run(RouletteApplication.class, args);
        System.out.println("Roulette started...");
    }
}