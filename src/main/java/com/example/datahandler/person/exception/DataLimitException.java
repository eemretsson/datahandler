package com.example.datahandler.person.exception;

// Om limit inte är ett positivt heltal = 400 Bad request
public class DataLimitException extends RuntimeException {
    public DataLimitException(String message){
        super(message);
    }
}
