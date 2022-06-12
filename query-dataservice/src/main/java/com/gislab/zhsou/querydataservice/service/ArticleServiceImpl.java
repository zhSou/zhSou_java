package com.gislab.zhsou.querydataservice.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gislab.zhsou.common.service.api.ArticleInterface;
import com.gislab.zhsou.common.service.entity.ArticleModel;
import com.gislab.zhsou.common.service.entity.ArticleRequestVO;
import com.gislab.zhsou.common.service.entity.ResponseVO;
import com.gislab.zhsou.querydataservice.mapper.ArticleMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author sky
 * @create 2022-05-17 16:06
 */
public class ArticleServiceImpl  implements ArticleInterface {

    @Resource
    private ArticleMapper articleMapper;

    //调用第三方搜索接口
    @Override
    public ResponseVO getArticle(ArticleRequestVO articleRequestVO) {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        JSONObject jo = null;

        HttpPost httpPost = new HttpPost("http://server.zhangzqs.cn:8080/query");
        String jsonString = JSON.toJSONString(articleRequestVO);
        StringEntity entity = new StringEntity(jsonString, "UTF-8");

        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity responseentity = response.getEntity();
                String s = EntityUtils.toString(responseentity);
                JSONObject datas = JSONObject.parseObject(s);
                System.out.println(datas.toString() );
                JSONObject data = JSONObject.parseObject(datas.get("data").toString());
                jo = JSONObject.parseObject(data.toJSONString());
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
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
        ResponseVO responseVO = new ResponseVO();
        responseVO.setPage(Integer.valueOf(jo.get("page").toString()));
        responseVO.setTotalPage(Integer.valueOf(jo.get("totalPage").toString()));
        responseVO.setTotal(Integer.valueOf(jo.get("total").toString()));
        JSONArray records = JSONObject.parseArray(jo.get("records").toString());//"records"是根据返回值设定
        if (!records.isEmpty()) {//如果返回的数据不为空
            responseVO.setArticleModel(JSONArray.parseArray(records.toJSONString(), ArticleModel.class));//转换成对象
        }
        return responseVO;
    }


    //pg专用
/*    @Override
    public PageInfo<ArticleModel> getArticle(ArticleRequestVO articleRequestVO) {

        StringBuffer buffer = new StringBuffer();
        List<String> query = articleRequestVO.getQuery();
        for ( String q : query ){
            buffer.append(q);
            buffer.append("&");
        }
        String s = buffer.deleteCharAt(buffer.length() - 1).toString();
        PageHelper.startPage(articleRequestVO.getPage(),articleRequestVO.getNum());
        List<ArticleModel> article = articleMapper.getArticle(s);
        PageInfo<ArticleModel> info = new PageInfo<>(article);
        return info;
    }*/

    //pg专用
/*    @Override
    public PageInfo<ArticleModel> getArticleWithFilter(ArticleRequestVO articleRequestVO) {
        StringBuffer buffer = new StringBuffer();
        List<String> query = articleRequestVO.getQuery();
        List<String> filter = articleRequestVO.getFilter();
        for ( String q : query )
            buffer.append(q + "&");

        for ( String f :filter )
            buffer.append("!" + f + "&");
        String s = buffer.deleteCharAt(buffer.length() - 1).toString();
        PageHelper.startPage(articleRequestVO.getPage(),articleRequestVO.getNum());
        List<ArticleModel> article = articleMapper.getArticleWithFilter(s);
        PageInfo<ArticleModel> info = new PageInfo<>(article);
        return info;
    }*/
}
