package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Hello from Docker + Jenkins CI Pipeline!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Welcome Shobha! Docker Integration is successful.";
    }
}