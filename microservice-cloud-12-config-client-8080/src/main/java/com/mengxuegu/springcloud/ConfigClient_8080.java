package com.mengxuegu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigClient_8080 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient_8080.class,args);
    }

}

/**

 浏览器访问：http://localhost:4001/config
 结果：applicationName: microservice-config-prod, port: 4002
 成功实现Config客户端访问 Config 配置服务中心，从而通过GitHub获取到配置信息

 * */
