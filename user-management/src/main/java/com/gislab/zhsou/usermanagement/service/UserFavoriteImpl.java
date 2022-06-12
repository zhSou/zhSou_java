package com.gislab.zhsou.usermanagement.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.gislab.zhsou.common.exception.AppException;
import com.gislab.zhsou.common.exception.AppExceptionType;
import com.gislab.zhsou.common.service.api.UserFavoriteInterface;
import com.gislab.zhsou.common.service.entity.FavoriteModel;
import com.gislab.zhsou.usermanagement.mapper.UserFavoriteMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

/**
 * @description:
 * @author: dai
 * @date: 2022/5/9
 */
public class UserFavoriteImpl implements UserFavoriteInterface {
    @Resource
    private UserFavoriteMapper userFavoriteMapper;

    @Override
    public void addFavorite(Long userId, Long articleId, String folderName) {
        userFavoriteMapper.addFavorite(userId, articleId, new Date(), folderName);
    }

    @Override
    @Transactional
    public void reNameFolder(Long userId, String oldName, String newName) {
        if (userFavoriteMapper.checkFolder(userId, newName)) {
            throw new AppException(AppExceptionType.USER_EXCEPTION.name(), "收藏夹已存在");
        } else {
            userFavoriteMapper.reNameFavoriteByFolder(userId, oldName, newName);
            userFavoriteMapper.reNameFolder(userId, oldName, newName);
        }
    }

    @Override
    public void delFavorite(Long userId, Long articleId, String folderName) {
        userFavoriteMapper.delFavorite(userId, articleId, folderName);
    }

    @Override
    public void addFolder(Long userId, String folderName) {
        if (userFavoriteMapper.checkFolder(userId, folderName)) {
            throw new AppException(AppExceptionType.USER_EXCEPTION.name(), "收藏夹已存在");
        } else {
            userFavoriteMapper.addFolder(userId, folderName, new Date());
        }
    }

    @Override
    @Transactional
    public void delFolder(Long userId, String folderName) {
        userFavoriteMapper.delFavoriteByFolder(userId, folderName);
        userFavoriteMapper.delFolder(userId, folderName);
    }

    @Override
    public String getFavoriteByFolder(Long userId, String folderName) {
        List<Integer> articleid = userFavoriteMapper.getArticleByFolder(userId, folderName);
        for ( int i : articleid )
            System.out.println(i);
        String httpEntity = getArticleByfolder(articleid);
        return httpEntity;
    }

    @Override
    public FavoriteModel getFavoriteByUser(Long userId) {
        FavoriteModel favoriteModel = new FavoriteModel();
        List<String> folders = userFavoriteMapper.getFolderByUser(userId);
        HashMap<String, String> result = getfavoriteByuser(userId, folders);
        favoriteModel.setFavorites(result);
        return favoriteModel;
    }

    @Override
    public Set<Long> getFavoriteIdByUser(Long userId) {
        List<Long> favoriteIdByUser = userFavoriteMapper.getFavoriteIdByUser(userId);
        return new HashSet<>(favoriteIdByUser);
    }

    @Override
    public List<String> getFolderByUser(Long userId) {
        return userFavoriteMapper.getFolderByUser(userId);
    }

    @Override
    public void updateFavoriteFolder(Long userId, Long articleId, String oldName, String newName) {
        userFavoriteMapper.updateFavoriteFolder(userId, articleId, oldName, newName);
    }


    private String getArticleByfolder(List<Integer> id) {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        JSONArray records = null;
        HttpPost httpPost = new HttpPost("http://server.zhangzqs.cn:8080/getDocuments");
        String jsonString = JSON.toJSONString(id);
        StringEntity entity = new StringEntity(jsonString, "UTF-8");

        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");

        CloseableHttpResponse response = null;
        String result = null;
        try {
            response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity  responseentity = response.getEntity();
                result =  EntityUtils.toString(responseentity);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    private HashMap<String, String> getfavoriteByuser( Long userId ,List<String> folders) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        JSONArray records = null;
        HttpPost httpPost = new HttpPost("http://server.zhangzqs.cn:8080/getDocuments");
        HashMap<String, String> result = new HashMap<>();

        CloseableHttpResponse response = null;
        HttpEntity responseentity = null;
        try {

            for (String folder : folders) {
                List<Integer> id = userFavoriteMapper.getArticleByFolder(userId, folder);
                String jsonString = JSON.toJSONString(id);
                StringEntity entity = new StringEntity(jsonString, "UTF-8");

                httpPost.setEntity(entity);
                httpPost.setHeader("Content-Type", "application/json;charset=utf8");
                response = httpClient.execute(httpPost);
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    responseentity = response.getEntity();
                }
                result.put(folder, EntityUtils.toString(responseentity));
                response.close();
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
