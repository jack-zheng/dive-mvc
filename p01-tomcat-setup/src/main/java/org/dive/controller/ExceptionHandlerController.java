package org.dive.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class ExceptionHandlerController {
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<String> handleException(Exception e) {
        System.out.println("Final caught...");
        return ResponseEntity.ok("Exception Error");
    }

    @ExceptionHandler({ RuntimeException.class })
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        System.out.println("Runtime caught...");
        return ResponseEntity.ok("Runtime Error");
    }

    @ExceptionHandler({ IllegalArgumentException.class })
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        System.out.println("Illegal Argument caught...");
        return ResponseEntity.ok("Illegal Argument Error");
    }
}
