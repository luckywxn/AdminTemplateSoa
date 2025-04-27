package com.strongculture.service.common.utils;

import com.strongculture.service.dao.entity.system.UserPO;

public class RequestUtil {

    private static final ThreadLocal<UserPO> USER_THREAD_LOCAL = new ThreadLocal<>();

    public static void setCurrentUser(UserPO user) {
        USER_THREAD_LOCAL.set(user);
    }

    public static UserPO getCurrentUser() {
        return USER_THREAD_LOCAL.get();
    }

    public static void removeCurrentUser() {
        USER_THREAD_LOCAL.remove();
    }

}
