package com.example.springmvcexample.example;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
@RequiredArgsConstructor
public class GreetingsController {

    private final GreetingsService service;

    @GetMapping
    public ResponseEntity<String> hello() {

        service.hello();

        return new ResponseEntity<>("Hello world!", HttpStatus.CREATED);
    }
}
