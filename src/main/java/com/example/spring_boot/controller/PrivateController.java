package com.example.spring_boot.controller;

import com.example.spring_boot.anotation.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 내부 사용자, 세션이 인증된 사용자만 넘긴다.
//  => 인증 / 권한이 있는 사용자만 넘어오게 해야 한다....어떻게??
// 커스텀 어노테이션을 생성한다.(Auth 어노테이션)
@RestController
@RequestMapping("/api/private")
@Auth
@Slf4j
public class PrivateController {

    @GetMapping("/hello")
    public String hello(){
        log.info("private hello controller");
        return "private hello";
    }
}
