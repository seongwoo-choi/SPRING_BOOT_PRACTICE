package com.example.spring_boot.controller;


import com.example.spring_boot.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {

    // @Valid => dto 에서 유효성 체크를 한 것을 사용하겠다는 뜻
    // BindingResult 를 사용하면 Validation 에 대한 결과가 값으로 들어온다.
    @PostMapping("/user")
    public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult) {

        // bindingResult 에 에러가 존재할 경우
        if(bindingResult.hasErrors()) {
            // StringBuilder 생성
            StringBuilder sb = new StringBuilder();
            // bindingResult 의 모든 에러들을 가져오고 forEach 를 통해 모든 에러들에 대한 로직 처리를 한다.
            bindingResult.getAllErrors().forEach(objectError -> {
                // 어떠한 필드에서 오류가 났는지 FieldError 타입을 이용하여 필드오류를 가져온다.
                FieldError field = (FieldError) objectError;
                // 문자열 msg 에 어떠한 오류 메시지가 출력되고 있는지를 저장
                String msg = objectError.getDefaultMessage();
                System.out.println("field" + field.getField());
                System.out.println(msg);

                // sb 에 문자열을 쌓는다.
                sb.append("field : "+ field.getField());
                sb.append(", msg : "+msg);
            });

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }


        return ResponseEntity.ok(user);
    }

}
