package com.example.spring_boot.controller;

import com.example.spring_boot.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/temp")
public class ApiUserController {

    @PostMapping("")
    public User user(@RequestBody User user){
        log.info("Temp : {}", user);
        return user;
    }
}
