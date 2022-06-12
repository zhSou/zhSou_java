package com.gislab.zhsou.usermanagement.mapper;

import com.gislab.zhsou.common.service.entity.UserModel;
import com.gislab.zhsou.common.service.entity.UserRegisterModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @author: dai
 * @date: 2022/5/7
 */

@Mapper
public interface UserMapper {
    public void registerUser(@Param("userRegisterModel") UserRegisterModel userRegisterModel);
    public void delUser(@Param("userId") Long userId);
    public boolean checkUserName(@Param("userName") String userName);
    public boolean checkEmail(@Param("email") String email);
    public String getPwdByName(@Param("userName") String userName);
    public Long getIdByName(@Param("userName") String userName);
    public UserModel getUserById(@Param("userId") Long userId);
}
