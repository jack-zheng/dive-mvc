package org.dive.proxy;

public class StaticProxyTest {
    public static void main(String[] args) {
        UserService userService = new UserService();
        StaticUserServiceProxy staticUserServiceProxy = new StaticUserServiceProxy(userService);
        staticUserServiceProxy.save();
    }
}

class StaticUserServiceProxy {
    private final UserService userService;

    public StaticUserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    public void save() {
        System.out.println("----- before -----");
        userService.save();
        System.out.println("----- after -----");
    }
}

class UserService {
    public void save() {
        System.out.println("save a user");
    }
}