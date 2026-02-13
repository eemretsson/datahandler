package com.example.datahandler.person.exception;

// Fel om filen saknas eller är ogiltig = 500 Internal server error
public class DataReadException extends RuntimeException {
    public DataReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
