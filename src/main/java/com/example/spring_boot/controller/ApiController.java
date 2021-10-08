package com.example.spring_boot.controller;


import com.example.spring_boot.dto.User;
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

@RestController
@RequestMapping("/api/user")
@Validated // RequestParam 에 대한 유효성 검사가 가능해진다.
public class ApiController {

    @GetMapping("")
    public User get(
            @Size(min=2, max=10) // RequestParam 에 대한 범위 설정
            @RequestParam(required = false) String name,

            @NotNull // RequestParam 에 대한 범위 설정
            @Min(1)
            @RequestParam(required = false) Integer age){
        User user = new User();
        user.setName(name);
        user.setAge(age);

        // age 에 값이 들어오지 않는다면 a 는 null 이 된다.
        int a = 10 + age;

        return user;
    }

    @PostMapping("")
    public User post(@Valid @RequestBody User user){
        System.out.println(user);

        return user;
    }

}
