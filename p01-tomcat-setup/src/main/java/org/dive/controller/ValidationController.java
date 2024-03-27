package org.dive.controller;

import org.dive.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;

@RestController
public class ValidationController {
    @GetMapping("/validate/{id}")
    public User validate(@PathVariable("id") int id) {
        return new User("John", "abc");
    }

    @GetMapping("/validate")
    public User getValidation(@RequestParam("name") String name, @RequestParam("email") String email) {
        User user = new User(name, email);
        System.out.println(user);
        return user;
    }

    @PostMapping(value = "/validate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String postValidation(@RequestBody User user) {
        System.out.println(user);
        return "Hello World";
    }
}
