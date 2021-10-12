package com.example.spring_boot.config;

import com.example.spring_boot.interceptor.AuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor // 파이널로 선언된 객체들을 생성자에서 주입받을 수 있게 해준다. DI 라고 생각하면 편하다. 순환참조를 막기 위해 사용한다.
public class MvcConfig implements WebMvcConfigurer {

    private final AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns => 검사하고 싶은 패턴을 추가할 수 있다.
        // excludePathPatterns => 빼고 싶은 패턴을 넣을 수 있다.
        registry.addInterceptor(authInterceptor).addPathPatterns("/api/private/*");
    }
}
