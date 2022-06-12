package com.gislab.zhsou.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.gislab.zhsou.common.util.JWTUtil;
import com.gislab.zhsou.gateway.common.ContextHolder;
import com.gislab.zhsou.gateway.common.ResponseMessage;
import com.google.common.base.Splitter;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @description:
 * @author: dai
 * @date: 2022/5/9
 */
@Component
public class AuthFilter extends OncePerRequestFilter {

    public static final String HEADER_STRING = "Authorization";
    public static final String AUTH_PATH = "/login";

    public static final String IGNORE_PATH = "/register,/index,/swagger-ui.html";

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if (httpServletRequest.getServletPath().equals(AUTH_PATH)) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        List<String> ignoreUrls = Splitter.on(",").trimResults().omitEmptyStrings().splitToList(IGNORE_PATH);
        if (!CollectionUtils.isEmpty(ignoreUrls)) {
            for (String url : ignoreUrls) {
                if (httpServletRequest.getServletPath().equals(url)) {
                    filterChain.doFilter(httpServletRequest, httpServletResponse);
                    return;
                }
            }
        }

        String token = httpServletRequest.getHeader(HEADER_STRING);
        if (null != token && token.startsWith("Bearer")) {
            token = token.substring(7);
            try {
                if (JWTUtil.isTokenExpired(token)) {
                    render(httpServletResponse, JSON.toJSONString(ResponseMessage.invokeFail("TOKEN过期"),
                            SerializerFeature.WriteMapNullValue));
                    return;
                }
                Long userId = JWTUtil.getUserId(token);
                ContextHolder.add(userId);
            } catch (Exception e) {
                render(httpServletResponse, JSON.toJSONString(ResponseMessage.invokeFail("TOKEN验证错误"),
                        SerializerFeature.WriteMapNullValue));
            }
        } else {
            render(httpServletResponse, JSON.toJSONString(ResponseMessage.invokeFail("请先登录"),
                    SerializerFeature.WriteMapNullValue));
            return;
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private void render(HttpServletResponse httpServletResponse, String msg) {
        try {
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setCharacterEncoding("UTF-8");
            PrintWriter writer = httpServletResponse.getWriter();
            writer.write(msg);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
