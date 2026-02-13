package com.example.datahandler.person.exception;

// Fel om filen är tom eller inga rader hittas = 204 No Content
public class NoDataFoundException extends RuntimeException {
    public NoDataFoundException(String message) {
        super(message);
    }
}
