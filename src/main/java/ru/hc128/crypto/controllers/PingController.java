package ru.hc128.crypto.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PingController {

    @GetMapping("/ping")
    public String getPing() {
        return "ok, HC-128 VERSION 0.1.0";
    }


}
