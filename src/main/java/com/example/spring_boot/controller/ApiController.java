package com.example.spring_boot.controller;


import com.example.spring_boot.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// lombok 을 사용하면 Slf4j 사용 가능 => log.info() 로 정보를 찍을 수 있다.
@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/user")
    public User user(@RequestBody User user){
        log.info("user : {}, {}", user, user);

        return user;
    }

}
