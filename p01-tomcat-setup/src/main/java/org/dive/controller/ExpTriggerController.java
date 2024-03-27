package org.dive.controller;

import org.dive.exceptions.SimpleException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class ExpTriggerController extends ExceptionHandlerController {
    @GetMapping("/io-exception")
    public void triggerIOException() throws IOException {
        System.out.println("Triggering IO Exception");
        throw new IOException("IO Exception");
    }

    @GetMapping("/arg-exception")
    public void triggerIllegalArgException() {
        System.out.println("Triggering Illegal Argument Exception");
        throw new IllegalArgumentException("Illegal Argument Exception");
    }

    @GetMapping("/rt-exception")
    public void triggerRTException() {
        System.out.println("Triggering RT Exception");
        throw new RuntimeException("RT Exception");
    }

    @GetMapping("/simple-exception")
    public void triggerSimpleException() throws SimpleException {
        System.out.println("Triggering Simple Exception");
        throw new SimpleException("Simple Exception");
    }
}
