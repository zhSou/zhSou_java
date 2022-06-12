package com.gislab.zhsou.common.service.api;

import com.gislab.zhsou.common.service.entity.UserAuthModel;
import com.gislab.zhsou.common.service.entity.UserModel;
import com.gislab.zhsou.common.service.entity.UserRegisterModel;

/**
 * @description: 用户服务
 * @author: dai
 * @date: 2022/5/7
 */
public interface UserServiceInterface {
    public void registerUser(UserRegisterModel userRegisterModel);
    public void delUser(Long userId);
    public String login(UserAuthModel userAuthModel);
    public UserModel getUser(Long userId);
}
