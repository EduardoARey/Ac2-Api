package com.example.demo.Exceptions;

import java.util.List;

public class ApiErrors {
    
    private String message;

    public String getMessage() {
        return message;
    }
    private List<String> errors;

    public List<String> getErrors() {
        return errors;
    }

    public ApiErrors(String message) {
        this.message = message;
    }

    public ApiErrors(List<String> errors) {
        this.errors = errors;
    }
}