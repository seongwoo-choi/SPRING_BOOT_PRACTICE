package com.example.spring_boot.interceptor;

import com.example.spring_boot.anotation.Auth;
import com.example.spring_boot.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;


// 특정 컨트롤러의 특정 메소드만 권한 검사를 하고 싶다 => 인터셉터 / MvcConfig 를 사용하여 설정할 수 있지만
// 좋은 방식은 아니고 Auth 어노테이션을 특정 컨트롤러에 걸어주는 게 좋다.
@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();
        URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI()).query(request.getQueryString()).build().toUri();

        log.info("request url : {}", url);
        boolean hasAnnotation = checkAnnotaion(handler, Auth.class);
        log.info("has annotation : {}", hasAnnotation);

        // 나의 서버는 모두 PUBLIC 으로 동작을 한다.
        // 단, Auth 권한을 가진 요청에 대해서는 세션, 쿠키,,
        if (hasAnnotation) {
            // 권한체크  return true;
            String query = uri.getQuery();
            if (query.equals("name=steve")) {
                return true;
            }

            throw new AuthException();
        }

        return true;
    }

    private boolean checkAnnotaion(Object handler, Class clazz) {

        // resource, javascript, html => 통과
        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        }

        // annotation check => 어노테이션을 가지고 있으면 통과(Auth annotaion)
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if (null != handlerMethod.getMethodAnnotation(clazz) || null != handlerMethod.getBeanType().getAnnotation(clazz)) {
            return true;
        }

        return false;

    }
}