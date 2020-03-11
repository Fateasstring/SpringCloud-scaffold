package com.mengxuegu.springcloud.service;

import com.mengxuegu.springcloud.entities.Product;
import org.springframework.stereotype.Component;
import java.util.List;

/** 熔断处理类，实现ProductClientService接口 */
@Component /** 该注解将此类加入容器中 */
public class ProductClientServiceFallBack implements ProductClientService{

    @Override
    public boolean add(Product product) {
        return false;
    }

    @Override
    public Product get(Long id) {

        /** 通过使用get方法的有参构造器进行构建 */
        return new Product(id, "ID = " + id + " 查无有效数据！ --- @feignclient&hystrix",
                "查无有效数据库！");
    }

    @Override
    public List<Product> list() {
        return null;
    }
}
