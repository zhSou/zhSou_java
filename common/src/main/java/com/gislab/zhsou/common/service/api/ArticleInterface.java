package com.gislab.zhsou.common.service.api;

import com.gislab.zhsou.common.service.entity.ArticleRequestVO;
import com.gislab.zhsou.common.service.entity.ResponseVO;

/**
 * @author sky
 * @create 2022-05-17 15:50
 */
public interface ArticleInterface {

    //@param query 普通查询条件
    ResponseVO getArticle(ArticleRequestVO articleRequestVO);


/*    //@param query 普通查询条件
    //@param filter 过滤条件
    PageInfo<ArticleModel> getArticleWithFilter(ArticleRequestVO articleRequestVO);*/
}
