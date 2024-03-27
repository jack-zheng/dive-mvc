package org.dive.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

//@ControllerAdvice
public class AnnoExpController {

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<String> handleException(Exception e) {
        System.out.println("Final caught...");
        return ResponseEntity.ok("Exception Error");
    }

    @ExceptionHandler({ IOException.class })
    public ResponseEntity<String> handleIOException(IOException e) {
        System.out.println("IO caught...");
        throw new RuntimeException("IO Error -> RT Error");
    }
}
