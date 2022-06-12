package com.gislab.zhsou.common.service.entity;

import java.io.Serializable;

/**
 * @description: 用户信息
 * @author: dai
 * @date: 2022/5/7
 */
public class UserModel implements Serializable {
    private static final long serialVersionUID = 3609781214214747783L;

    private String id;
    private String userName;
    private String email;

    public UserModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
