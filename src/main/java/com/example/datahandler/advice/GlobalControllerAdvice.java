package com.example.datahandler.advice;

import com.example.datahandler.person.exception.DataLimitException;
import com.example.datahandler.person.exception.DataReadException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(DataReadException.class)
    public ResponseEntity<String> handleDataReadException(DataReadException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ex.getMessage());
    }

    @ExceptionHandler(DataLimitException.class)
    public ResponseEntity<String> handleDataLimitException(DataLimitException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleLimitTypeMismatch(MethodArgumentTypeMismatchException ex) {
        DataLimitException dataLimitException = new DataLimitException("Parametern limit måste vara ett positivt heltal");
        return handleDataLimitException(dataLimitException);
    }
}
