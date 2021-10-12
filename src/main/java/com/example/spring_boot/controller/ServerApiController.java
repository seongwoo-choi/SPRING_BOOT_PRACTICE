package com.example.spring_boot.controller;

import com.example.spring_boot.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerApiController {

    @GetMapping("/hello")
    public User hello(@RequestParam String name, @RequestParam int age){
        User user = new User();
        user.setAge(age);
        user.setName(name);

        return user;
    }

    @PostMapping("/user/{userId}/age/{userName}")
    public User post(@RequestBody User user, @PathVariable int userId, @PathVariable String userName){
        log.info("userId : {}, userName: {}", userId, userName);
        log.info("client req : {}", user);

        return user;
    }
}
