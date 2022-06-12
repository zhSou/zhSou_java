package com.gislab.zhsou.gateway.common;

import java.io.Serializable;

/**
 * @description: 返回消息
 * @author: dai
 * @date: 2022/5/7
 */
public class ResponseMessage implements Serializable {
    private static final long serialVersionUID = -7905036981177157821L;

    private String code;

    private String info;

    private Object data;

    private ResponseMessage() {
    }

    public static ResponseMessage invokeSuccess() {
        ResponseMessage message = new ResponseMessage();
        message.code = "0";
        return message;
    }

    public static ResponseMessage invokeSuccess(Object data) {
        ResponseMessage message = new ResponseMessage();
        message.code = "0";
        message.data = data;
        return message;
    }

    public static ResponseMessage invokeFail(String info) {
        ResponseMessage message = new ResponseMessage();
        message.code = "1";
        message.info = info;
        return message;
    }

    public static ResponseMessage invokeFail(String info, Object data) {
        ResponseMessage message = new ResponseMessage();
        message.code = "1";
        message.info = info;
        message.data = data;
        return message;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }

    public Object getData() {
        return data;
    }
}
