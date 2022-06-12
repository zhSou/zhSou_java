package com.gislab.zhsou.gateway.controller;

import com.gislab.zhsou.common.service.api.ArticleInterface;
import com.gislab.zhsou.common.service.entity.ArticleRequestVO;
import com.gislab.zhsou.common.service.entity.ResponseVO;
import com.gislab.zhsou.gateway.common.ResponseMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sky
 * @create 2022-05-17 16:02
 */
@RestController
public class ArticleController {

    private  final ArticleInterface articleInterface;

    public ArticleController(ArticleInterface articleInterface) {
        this.articleInterface = articleInterface;
    }

    @RequestMapping(value = "/getArticle", method = RequestMethod.POST)
    public ResponseMessage getArticle(@RequestBody ArticleRequestVO articleRequestVO) {
        ResponseVO result = articleInterface.getArticle(articleRequestVO);
        return ResponseMessage.invokeSuccess(result);
    }

/*    @RequestMapping(value = "/getArticleWithFilter", method = RequestMethod.POST)
    public ResponseMessage getArticleWithFilter(@RequestBody ArticleRequestVO articleRequestVO) {
        PageInfo<ArticleModel> result = articleInterface.getArticleWithFilter(articleRequestVO);
        return ResponseMessage.invokeSuccess(result);
    }*/
}
