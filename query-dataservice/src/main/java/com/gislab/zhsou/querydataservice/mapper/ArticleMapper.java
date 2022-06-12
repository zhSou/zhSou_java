package com.gislab.zhsou.querydataservice.mapper;

import com.gislab.zhsou.common.service.entity.ArticleModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sky
 * @create 2022-05-17 16:12
 */
@Mapper
public interface ArticleMapper {

    List<ArticleModel> getArticle(@Param("s") String s);

    List<ArticleModel> getArticleWithFilter(@Param("s") String s);
}
