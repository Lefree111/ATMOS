package com.company.exp;

public class AlreadyUpdateStatusExseption extends RuntimeException{
    public AlreadyUpdateStatusExseption(String message) {
        super(message);
    }
}
