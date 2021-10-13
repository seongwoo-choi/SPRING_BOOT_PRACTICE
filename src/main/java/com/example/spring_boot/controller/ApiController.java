package com.example.spring_boot.controller;


import com.example.spring_boot.dto.User;
import com.example.spring_boot.dto.UserReq;
import com.example.spring_boot.dto.UserRes;
import com.example.spring_boot.service.AsyncService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
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

    @PostMapping("/user1")
    public User userPost(@RequestBody User user) {
        log.info("user : {}, {}", user, user);

        return user;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "x", value = "x 값", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "y", value = "y 값", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping("/plus/{x}")
    public int plus(@PathVariable int x, @RequestParam int y) {
        return x + y;
    }

    @ApiResponse(code = 502, message = "사용자의 나이가 10살 이하일 때")
    @ApiOperation(value = "사용자의 이름과 나이를 리턴 하는 메소드")
    @GetMapping("/user")
    public UserRes userGet(UserReq userReq) {
        return new UserRes(userReq.getName(), userReq.getAge());
    }

    @PostMapping("/user")
    public UserRes userPost2(@RequestBody UserReq userReq) {
        return new UserRes(userReq.getName(), userReq.getAge());
    }

    @GetMapping("/hello1")
    public CompletableFuture hello() {
        log.info("completable future init");
        return asyncService.run();
    }

}
