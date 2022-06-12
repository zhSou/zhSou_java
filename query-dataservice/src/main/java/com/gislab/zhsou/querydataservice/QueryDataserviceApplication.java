package com.gislab.zhsou.querydataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = {"classpath:dubbo-config.xml"})
public class QueryDataserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(QueryDataserviceApplication.class, args);
    }

}
