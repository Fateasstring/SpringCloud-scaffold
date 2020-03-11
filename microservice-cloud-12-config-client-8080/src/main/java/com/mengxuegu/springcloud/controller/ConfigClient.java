package com.mengxuegu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClient {

    /**  会从github的microservice-config-application.yml中获取 */
    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private String port;

    @GetMapping("/config")
    public String config() {
        String content = "applicationName: " + applicationName + ", port: " + port;
        System.out.println(content);

        /** 将结果响应到页面 */
        return content;
    }
}

/**
 浏览器访问：http://localhost:4001/config
 结果：applicationName: microservice-config-prod, port: 4002
 成功实现Config客户端访问 Config 配置服务中心，从而通过GitHub获取到配置信息

 * */
