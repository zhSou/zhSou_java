package com.gislab.zhsou.usermanagement.service;

import cn.hutool.crypto.SecureUtil;
import com.gislab.zhsou.common.exception.AppException;
import com.gislab.zhsou.common.exception.AppExceptionType;
import com.gislab.zhsou.common.service.api.UserServiceInterface;
import com.gislab.zhsou.common.service.entity.UserAuthModel;
import com.gislab.zhsou.common.service.entity.UserModel;
import com.gislab.zhsou.common.service.entity.UserRegisterModel;
import com.gislab.zhsou.common.util.JWTUtil;
import com.gislab.zhsou.usermanagement.mapper.UserFavoriteMapper;
import com.gislab.zhsou.usermanagement.mapper.UserMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @description:
 * @author: dai
 * @date: 2022/5/7
 */
public class UserServiceImpl implements UserServiceInterface {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserFavoriteMapper userFavoriteMapper;

    @Override
    public void registerUser(UserRegisterModel userRegisterModel) {
        boolean checkUserName = userMapper.checkUserName(userRegisterModel.getUserName());
        if (checkUserName) {
            throw new AppException(AppExceptionType.USER_EXCEPTION.name(), "用户名已被占用");
        }
        boolean checkEmail = userMapper.checkEmail(userRegisterModel.getEmail());
        if (checkEmail) {
            throw new AppException(AppExceptionType.USER_EXCEPTION.name(), "邮箱已被占用");
        }
        String pwd = SecureUtil.md5(userRegisterModel.getPassword());
        userRegisterModel.setPassword(pwd);
        userMapper.registerUser(userRegisterModel);
    }

    @Override
    @Transactional
    public void delUser(Long userId) {
        userFavoriteMapper.delFavoriteAll(userId);
        userFavoriteMapper.delFolderAll(userId);
        userMapper.delUser(userId);
    }

    @Override
    public String login(UserAuthModel userAuthModel) {
        String pwd = userMapper.getPwdByName(userAuthModel.getUserName());
        if (null != pwd && !pwd.isEmpty()) {
            if (pwd.equals(SecureUtil.md5(userAuthModel.getPassword()))) {
                Long userId = userMapper.getIdByName(userAuthModel.getUserName());
                return JWTUtil.generateToken(userId);
            } else {
                throw new AppException(AppExceptionType.USER_EXCEPTION.name(), "密码错误");
            }
        } else {
            throw new AppException(AppExceptionType.USER_EXCEPTION.name(), "用户不存在");
        }
    }

    @Override
    public UserModel getUser(Long userId) {
        UserModel user = userMapper.getUserById(userId);
        if (null != user) {
            return user;
        } else {
            throw new AppException(AppExceptionType.USER_EXCEPTION.name(), "用户ID不存在");
        }
    }
}
