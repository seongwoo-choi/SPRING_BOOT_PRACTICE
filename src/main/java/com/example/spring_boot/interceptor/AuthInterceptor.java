package com.example.spring_boot.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();

        log.info("request url : {}", url);

        return true;
    }

    private boolean checkAnnotaion(Object handler, Class clazz){

        // resource, javascript, html => 통과
        if( handler instanceof ResourceHttpRequestHandler) {
            return true;
        }

        // annotation check => 어노테이션을 가지고 있으면 통과(Auth annotaion)
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if(null != handlerMethod.getMethodAnnotation(clazz) || null != handlerMethod.getBeanType().getAnnotation(clazz)){
            return true;
        }

        return false;

    }
}