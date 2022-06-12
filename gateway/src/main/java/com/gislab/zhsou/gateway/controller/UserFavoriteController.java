package com.gislab.zhsou.gateway.controller;

import com.gislab.zhsou.common.service.api.UserFavoriteInterface;
import com.gislab.zhsou.common.service.entity.FavoriteModel;
import com.gislab.zhsou.gateway.common.ContextHolder;
import com.gislab.zhsou.gateway.common.ResponseMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: dai
 * @date: 2022/5/9
 */
@RestController
public class UserFavoriteController {
    private final UserFavoriteInterface userFavoriteInterface;

    public UserFavoriteController(UserFavoriteInterface userFavoriteInterface) {
        this.userFavoriteInterface = userFavoriteInterface;
    }

    @RequestMapping(value = "/getFavoritesByUser", method = RequestMethod.POST)
    public ResponseMessage getFavoritesByUser() {
        Long userId = ContextHolder.getUserId();
        FavoriteModel favoriteByUser = userFavoriteInterface.getFavoriteByUser(userId);
        return ResponseMessage.invokeSuccess(favoriteByUser);
    }

    @RequestMapping(value = "/addFolder", method = RequestMethod.POST)
    public ResponseMessage addFolder(String name) {
        Long userId = ContextHolder.getUserId();
        userFavoriteInterface.addFolder(userId, name);
        return ResponseMessage.invokeSuccess();
    }

    @RequestMapping(value = "/delFolder", method = RequestMethod.POST)
    public ResponseMessage delFolder(String folderName) {
        Long userId = ContextHolder.getUserId();
        userFavoriteInterface.delFolder(userId, folderName);
        return ResponseMessage.invokeSuccess();
    }

    @RequestMapping(value = "/reNameFolder", method = RequestMethod.POST)
    public ResponseMessage reNameFolder(String oldName, String newName) {
        Long userId = ContextHolder.getUserId();
        userFavoriteInterface.reNameFolder(userId, oldName, newName);
        return ResponseMessage.invokeSuccess();
    }

    @RequestMapping(value = "/getFolderByUser", method = RequestMethod.POST)
    public ResponseMessage getFolderByUser() {
        Long userId = ContextHolder.getUserId();
        List<String> folderByUser = userFavoriteInterface.getFolderByUser(userId);
        return ResponseMessage.invokeSuccess(folderByUser);
    }

    @RequestMapping(value = "/addFavorite", method = RequestMethod.POST)
    public ResponseMessage addFavorite(Long aid, String folderName) {
        Long userId = ContextHolder.getUserId();
        userFavoriteInterface.addFavorite(userId, aid, folderName);
        return ResponseMessage.invokeSuccess();
    }

    @RequestMapping(value = "/delFavorite", method = RequestMethod.POST)
    public ResponseMessage delFavorite(Long aid, String folderName) {
        Long userId = ContextHolder.getUserId();
        userFavoriteInterface.delFavorite(userId, aid, folderName);
        return ResponseMessage.invokeSuccess();
    }

    @RequestMapping(value = "/updateFavorite", method = RequestMethod.POST)
    public ResponseMessage updateFavorite(Long aid, String oldName, String newName) {
        Long userId = ContextHolder.getUserId();
        userFavoriteInterface.updateFavoriteFolder(userId, aid, oldName, newName);
        return ResponseMessage.invokeSuccess();
    }

    @RequestMapping(value = "/getFavoriteByFolder", method = RequestMethod.POST)
    public ResponseMessage getFavoriteByFolder(String folderName) {
        Long userId = ContextHolder.getUserId();
        String favoriteByFolder = userFavoriteInterface.getFavoriteByFolder(userId, folderName);
        return ResponseMessage.invokeSuccess(favoriteByFolder);
    }

}
