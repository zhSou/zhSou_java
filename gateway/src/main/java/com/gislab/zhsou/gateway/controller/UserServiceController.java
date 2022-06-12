package com.gislab.zhsou.gateway.controller;

import com.gislab.zhsou.common.service.api.UserServiceInterface;
import com.gislab.zhsou.common.service.entity.UserAuthModel;
import com.gislab.zhsou.common.service.entity.UserModel;
import com.gislab.zhsou.common.service.entity.UserRegisterModel;
import com.gislab.zhsou.gateway.common.ContextHolder;
import com.gislab.zhsou.gateway.common.ResponseMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: dai
 * @date: 2022/5/9
 */
@RestController
public class UserServiceController {
    private final UserServiceInterface userServiceInterface;

    public UserServiceController(UserServiceInterface userServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseMessage login(UserAuthModel userAuthModel) {
        String token = userServiceInterface.login(userAuthModel);
        return ResponseMessage.invokeSuccess(token);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseMessage logout() {
        // 前端删除JWT
        return ResponseMessage.invokeSuccess();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseMessage register(UserRegisterModel userRegisterModel) {
        userServiceInterface.registerUser(userRegisterModel);
        String userName = userRegisterModel.getUserName();
        String password = userRegisterModel.getPassword();
        UserAuthModel userAuthModel = new UserAuthModel();
        userAuthModel.setUserName(userName);
        userAuthModel.setPassword(password);
        String token = userServiceInterface.login(userAuthModel);
        return ResponseMessage.invokeSuccess(token);
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public ResponseMessage getUserInfo() {
        Long userId = ContextHolder.getUserId();
        UserModel user = userServiceInterface.getUser(userId);
        return ResponseMessage.invokeSuccess(user);
    }

    @RequestMapping(value = "/delUser", method = RequestMethod.POST)
    public ResponseMessage delUser() {
        Long userId = ContextHolder.getUserId();
        userServiceInterface.delUser(userId);
        return ResponseMessage.invokeSuccess();
    }
}
