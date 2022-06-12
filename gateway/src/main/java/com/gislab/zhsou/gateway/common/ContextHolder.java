package com.gislab.zhsou.gateway.common;

/**
 * @description:
 * @author: dai
 * @date: 2022/5/9
 */
public class ContextHolder {
    private static final InheritableThreadLocal<Long> userHolder = new InheritableThreadLocal<>();

    public static void add(Long userId) {
        userHolder.set(userId);
    }

    public static Long getUserId() {
        return userHolder.get();
    }

    public static void remove() {
        userHolder.remove();
    }
}
