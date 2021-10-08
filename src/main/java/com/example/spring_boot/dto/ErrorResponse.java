package com.example.spring_boot.dto;

import java.util.List;

public class ErrorResponse {

    String statusCode;
    String requestUrl;
    String code;
    String message;
    String resultCode;

    List<Error> errorlist;

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public void setErrorlist(List<Error> errorlist) {
        this.errorlist = errorlist;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getResultCode() {
        return resultCode;
    }

    public List<Error> getErrorlist() {
        return errorlist;
    }
}
