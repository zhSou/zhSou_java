package com.gislab.zhsou.common.service.entity;

import java.io.Serializable;

/**
 * @author sky
 * @create 2022-06-12 13:30
 */
public class Document implements Serializable {
    private String url;
    private String text;

    public Document() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
