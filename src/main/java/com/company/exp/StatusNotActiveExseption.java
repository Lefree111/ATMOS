package com.company.exp;

public class StatusNotActiveExseption extends RuntimeException{
    public StatusNotActiveExseption(String message) {
        super(message);
    }
}
