package com.example.spring_boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 누구나 접근할 수 있는 컨트롤러
@RestControllerAdvice
@RequestMapping("/api/public")
public class PublicController {

    @GetMapping("/hello")
    public String hello(){
        return "public hello";
    }
}
