package org.dive.springaopapi;

public class UserService {

    public void addUser(String username) {
        System.out.println("Adding user: " + username);
    }

    public void deleteUser(String username) {
        System.out.println("Deleting user: " + username);
    }
}

