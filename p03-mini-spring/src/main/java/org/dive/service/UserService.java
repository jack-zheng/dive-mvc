package org.dive.service;

import org.dive.spring.Autowired;
import org.dive.spring.Component;
import org.dive.spring.Scope;

@Component
@Scope
public class UserService {
    @Autowired
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }
}
