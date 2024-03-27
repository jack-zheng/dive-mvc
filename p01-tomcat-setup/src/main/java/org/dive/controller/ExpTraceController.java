package org.dive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

//@Controller
@RestController
public class ExpTraceController {
    @GetMapping("/exception")
    public void method(@RequestParam int count) throws IOException {
        System.out.println("Triggering IO Exception");
        throw new IOException("IO Exception");
    }
}
