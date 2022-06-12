package com.gislab.zhsou.common.service.entity;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @description:
 * @author: dai
 * @date: 2022/5/9
 */
public class FavoriteModel implements Serializable {
    private static final long serialVersionUID = 1404269452843449236L;
    private HashMap<String, String> favorites;

    public FavoriteModel() {
    }


    public HashMap<String, String> getFavorites() {
        return favorites;
    }

    public void setFavorites(HashMap<String, String> favorites) {
        this.favorites = favorites;
    }
}
