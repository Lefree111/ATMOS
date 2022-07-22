package com.company.exp;

public class WorkerAlreadyCreatedException extends RuntimeException{
    public WorkerAlreadyCreatedException(String message) {
        super(message);
    }
}
