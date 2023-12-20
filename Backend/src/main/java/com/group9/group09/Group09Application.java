package com.group9.group09;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Group09Application extends SpringBootServletInitializer {

    // Main method to run application
    public static void main(String[] args) {
        SpringApplication.run(Group09Application.class, args);
        System.out.println("Application Started");
    }
}