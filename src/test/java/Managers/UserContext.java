package Managers;

import models.User;

public class UserContext {
    private static ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

    public static User getCurrentUser() {
        return  userThreadLocal.get();
    }

    public static void setCurrentUser(User user){
        userThreadLocal.set(user);
    }
}
