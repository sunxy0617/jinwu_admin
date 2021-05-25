package cn.nayuguo.jw.common.util;

import cn.nayuguo.jw.model.UserIdentify;

/**
 * 保存当前线程登录用户
 *
 * @author Tuma_Coder
 */
public class LocalUser {
    /**
     * 使用线程变量存储当前用户信息
     */
    private final static ThreadLocal<UserIdentify> threadLocal = new ThreadLocal<>();

    public static void set(UserIdentify userIdentify) {
        threadLocal.set(userIdentify);
    }

    public static UserIdentify get() {
        return threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
    }
}
