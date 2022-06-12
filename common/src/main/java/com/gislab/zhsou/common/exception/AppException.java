package com.gislab.zhsou.common.exception;

import java.io.Serializable;

/**
 * @description:
 * @author: dai
 * @date: 2022/5/9
 */
public class AppException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1479503623560396664L;
    private String type;
    private String info;

    public AppException(String type, String info) {
        super(info);
        this.type = type;
        this.info = info;
    }

    public AppException(Throwable cause, String type, String info) {
        super(info, cause);
        this.type = type;
        this.info = info;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
