package com.company.exp;

public class CourseAlreadyCreatedExseption extends RuntimeException{
    public CourseAlreadyCreatedExseption(String message) {
        super(message);
    }
}
