package com.company.exp;

public class TeacherAlreadyCreatedException extends RuntimeException{
    public TeacherAlreadyCreatedException(String message) {
        super(message);
    }
}
