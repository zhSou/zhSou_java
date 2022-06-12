package com.gislab.zhsou.common.service.entity;

import java.io.Serializable;

/**
 * @author sky
 * @create 2022-06-12 12:17
 */
public class HighLight implements Serializable {
    private final String preTag = "<span style='color:red'>";
    private final String postTag = "</span>";

    public HighLight() {
    }

    public String getPreTag() {
        return preTag;
    }


    public String getPostTag() {
        return postTag;
    }

}
