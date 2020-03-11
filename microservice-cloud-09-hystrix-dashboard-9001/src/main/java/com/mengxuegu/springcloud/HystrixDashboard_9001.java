package com.mengxuegu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/** 开启服务监控 @SpringBootApplication */
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboard_9001 {

   public static void main(String[] args) {

       SpringApplication.run(HystrixDashboard_9001.class, args);

   }

}
