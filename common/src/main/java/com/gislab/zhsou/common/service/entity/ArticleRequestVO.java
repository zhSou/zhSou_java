package com.gislab.zhsou.common.service.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author sky
 * @create 2022-05-17 16:31
 */
public class ArticleRequestVO implements Serializable {
    private String query;
    private Integer page;
    private Integer limit;
    private List<String> filterWord;
    private HighLight highLight;

    public ArticleRequestVO() {
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<String> getFilterWord() {
        return filterWord;
    }

    public void setFilterWord(List<String> filterWord) {
        this.filterWord = filterWord;
    }

    public HighLight getHighLight() {
        return highLight;
    }

    public void setHighLight(HighLight highLight) {
        this.highLight = highLight;
    }
}
