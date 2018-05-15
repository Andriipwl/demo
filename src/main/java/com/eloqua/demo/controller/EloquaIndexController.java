package com.eloqua.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EloquaIndexController {
    @GetMapping("/")
    public void index(){

    }
}
