package com.example.springmvcexample.example;

import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class GreetingsService {

    public String hello() {
        throw new RuntimeException("Error");
    }
}
