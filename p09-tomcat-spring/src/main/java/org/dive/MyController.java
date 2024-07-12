package org.dive;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/hello")
    public String hello() {
        return "tomcat + spring / dispatch servlet works!";
    }

    // create a post request print the path variable
    @PostMapping("/path-test/{path}/sth")
    public ResponseEntity<Void> pathTest(@PathVariable("path") String path) {
        System.out.println("path: " + path);
        // return resp for 201
        return ResponseEntity.ok().build();
    }
}
