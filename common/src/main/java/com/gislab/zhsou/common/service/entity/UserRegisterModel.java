package com.gislab.zhsou.common.service.entity;

import java.io.Serializable;

/**
 * @description: 用户注册
 * @author: dai
 * @date: 2022/5/7
 */
public class UserRegisterModel implements Serializable {
    private static final long serialVersionUID = -6745406985092608073L;

    private String userName;
    private String password;
    private String email;

    public UserRegisterModel() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
