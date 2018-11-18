package ru.hc128.crypto.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ShutdownController {

    @GetMapping("/shutdown")
    public void shutdown() {
        System.exit(0);
    }
}
