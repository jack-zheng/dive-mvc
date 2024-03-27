package org.dive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathConvertController {
    @GetMapping(value = "/path/{id}")
    public String pathTest(@PathVariable("id") int id) {
        System.out.println("ID: " + id);
        return "Path Test";
    }
}
