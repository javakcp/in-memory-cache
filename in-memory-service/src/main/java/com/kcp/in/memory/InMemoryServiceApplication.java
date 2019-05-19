package com.kcp.in.memory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author kapanda
 *
 */
@SpringBootApplication
public class InMemoryServiceApplication {

    public static void main(String[] args) {
        System.out.println("initializing spring applciation");
        SpringApplication.run(InMemoryServiceApplication.class, args);
    }
}
