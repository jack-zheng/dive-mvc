package org.dive.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.dive.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private User requestUser;
    @Autowired
    private User sessionUser;
    @Autowired
    private User appUser;

    @GetMapping("/user")
    public String returnUser() {
        System.out.println("Request User: " + requestUser);
        System.out.println("Session User: " + sessionUser);
        System.out.println("App User: " + appUser);
        return "ok";
    }

    @GetMapping("/clean-session")
    public String cleanSession(HttpSession session) {
        session.invalidate();
        return "ok";
    }

    @GetMapping("/get-session")
    public String getSession(HttpServletRequest request) {
        request.getSession();
        return "ok";
    }
}
