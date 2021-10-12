package com.example.spring_boot.controller;


import com.example.spring_boot.dto.User;
import com.example.spring_boot.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


import java.util.concurrent.CompletableFuture;

// lombok 을 사용하면 Slf4j 사용 가능 => log.info() 로 정보를 찍을 수 있다.
@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {

    private final AsyncService asyncService;

    public ApiController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @PostMapping("/user")
    public User user(@RequestBody User user) {
        log.info("user : {}, {}", user, user);

        return user;
    }

    @GetMapping("/hello1")
    public CompletableFuture hello() {
        log.info("completable future init");
        return asyncService.run();
    }

}
