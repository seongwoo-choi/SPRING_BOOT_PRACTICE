package com.example.spring_boot.dto;

public class Error {

    private String field;
    private String message;
    private String invalidValue;

    public void setField(String field) {
        this.field = field;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setInvalidValue(String invalidValue) {
        this.invalidValue = invalidValue;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }

    public String getInvalidValue() {
        return invalidValue;
    }
}
