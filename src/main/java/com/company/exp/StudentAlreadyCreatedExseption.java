package com.company.exp;

public class StudentAlreadyCreatedExseption extends RuntimeException{
    public StudentAlreadyCreatedExseption(String message) {
        super(message);
    }
}
