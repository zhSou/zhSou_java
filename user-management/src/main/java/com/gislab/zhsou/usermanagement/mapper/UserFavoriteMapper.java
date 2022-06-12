package com.gislab.zhsou.usermanagement.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: dai
 * @date: 2022/5/9
 */
@Mapper
public interface UserFavoriteMapper {
    public void addFavorite(@Param("uid") Long uid, @Param("aid") Long aid, @Param("time") Date time,
                            @Param("folderName") String folderName);
    public void delFavorite(@Param("uid") Long uid, @Param("aid") Long aid,
                            @Param("folderName") String folderName);
    public void updateFavoriteFolder(@Param("uid") Long uid, @Param("aid") Long aid,
                                     @Param("oldName") String oldName, @Param("newName") String newName);
    public void addFolder(@Param("uid") Long uid, @Param("folderName") String folderName,
                          @Param("time") Date time);
    public boolean checkFolder(@Param("uid") Long uid, @Param("folderName") String folderName);
    public void delFolder(@Param("uid") Long uid, @Param("folderName") String folderName);
    public void delFavoriteByFolder(@Param("uid") Long uid, @Param("folderName") String folderName);
    public void reNameFolder(@Param("uid") Long uid, @Param("oldName") String oldName,
                             @Param("newName") String newName);
    public void reNameFavoriteByFolder(@Param("uid") Long uid, @Param("oldName") String oldName,
                                       @Param("newName") String newName);

    public List<String> getFolderByUser(@Param("uid") Long uid);

    public List<Integer> getArticleByFolder(@Param("uid") Long uid,
                                                 @Param("folderName") String folderName);
    public void delFolderAll(@Param("uid") Long uid);
    public void delFavoriteAll(@Param("uid") Long uid);
    public List<Long> getFavoriteIdByUser(@Param("uid") Long uid);
}
