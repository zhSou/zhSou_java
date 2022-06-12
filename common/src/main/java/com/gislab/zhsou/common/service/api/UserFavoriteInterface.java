package com.gislab.zhsou.common.service.api;

import com.gislab.zhsou.common.service.entity.FavoriteModel;

import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: dai
 * @date: 2022/5/9
 */
public interface UserFavoriteInterface {
    public void addFavorite(Long userId, Long articleId, String folderName);
    public void delFavorite(Long userId, Long articleId, String folderName);
    public void updateFavoriteFolder(Long userId, Long articleId, String oldName, String newName);
    public String getFavoriteByFolder(Long userId, String folderName);
    public FavoriteModel getFavoriteByUser(Long userId);
    public Set<Long> getFavoriteIdByUser(Long userId);
    public void addFolder(Long userId, String folderName);
    public void delFolder(Long userId, String folderName);
    public void reNameFolder(Long userId, String oldName, String newName);
    public List<String> getFolderByUser(Long userId);
}
