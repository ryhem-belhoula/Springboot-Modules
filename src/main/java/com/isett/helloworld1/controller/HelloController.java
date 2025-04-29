package com.isett.helloworld1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isett.helloworld1.model.Greeting;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {

    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/greeting")
    public String greeting() {
        return "Welcome to Spring Boot!";
    }

    @GetMapping("/api/greeting")
    public Greeting greetingJson(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }
}
