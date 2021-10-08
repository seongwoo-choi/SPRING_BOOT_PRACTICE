package com.example.spring_boot.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@Slf4j
// 필터는 제일 최전방에서 작업을 처리하는 곳이다!
// 보통 로깅용으로 많이 사용, 다단계 인증이 아니면 보통 인터셉터에서 인증을 구현한다.
// 상황에 따라 사람에 따라 다르다.
// 필터를 웹어플리케이션에 등록
@WebFilter(urlPatterns = "/api/user/*")
public class GlobalFilter implements Filter {

    // Filter 에서 req, res 를 확인해야 하는 상황일 경우
    // ContentCachingRequestWrapper / ContentCachingResponseWrapper 클래스를 사용하고 doFilter 작업 후에
    // 리퀘스트 바디에 있는 내용을 불러와서 log 로 찍으면 된다.
    // 또한 리스폰스 값을 찍되 copyBodyToResponse() 을 꼭 해줘야 클라이언트가 값을 받을 수 있다.
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // 전처리 구간
        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest) request);
        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper ((HttpServletResponse) response);

        String url = httpServletRequest.getRequestURI();

        chain.doFilter(httpServletRequest, httpServletResponse);

        // 후처리 구간
        // req
        String reqContent = new String(httpServletRequest.getContentAsByteArray());
        log.info("request url : {}, request body : {}", url, reqContent);

        String resContent = new String(httpServletResponse.getContentAsByteArray());
        int httpStatus = httpServletResponse.getStatus();

        httpServletResponse.copyBodyToResponse();

        log.info("response status: {}, response body: {}", httpStatus, resContent);

    }
}
