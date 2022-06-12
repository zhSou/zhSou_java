package com.gislab.zhsou.common.service.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author sky
 * @create 2022-06-12 12:20
 */
public class ResponseVO implements Serializable {

    private List<ArticleModel> articleModels;
    private Integer total;
    private Integer page;
    private Integer totalPage;

    public ResponseVO() {
    }

    public List<ArticleModel> getArticleModel() {
        return articleModels;
    }

    public void setArticleModel(List<ArticleModel> articleModels) {
        this.articleModels = articleModels;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
