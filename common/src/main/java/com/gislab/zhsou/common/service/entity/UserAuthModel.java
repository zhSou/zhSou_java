package com.gislab.zhsou.common.service.entity;

import java.io.Serializable;

/**
 * @description: 用户登录
 * @author: dai
 * @date: 2022/5/7
 */
public class UserAuthModel implements Serializable {
    private static final long serialVersionUID = 2083275821529218860L;

    private String userName;
    private String password;

    public UserAuthModel() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
