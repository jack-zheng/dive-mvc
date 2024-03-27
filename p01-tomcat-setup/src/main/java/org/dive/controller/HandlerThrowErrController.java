package org.dive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class HandlerThrowErrController {
    @GetMapping("/err-chain")
    public void throwErrChain() throws IOException {
        System.out.println("In Error Chain...");
        throw new IOException("Throwing IO Exception");
    }
}
