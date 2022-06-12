package com.gislab.zhsou.common.service.entity;

import java.io.Serializable;

/**
 * @description:
 * @author: dai
 * @date: 2022/5/9
 */
public class ArticleModel implements Serializable {
    private static final long serialVersionUID = 8225027487320277701L;
    private Long id;
    private String text;
    private  Document document;

    public ArticleModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
