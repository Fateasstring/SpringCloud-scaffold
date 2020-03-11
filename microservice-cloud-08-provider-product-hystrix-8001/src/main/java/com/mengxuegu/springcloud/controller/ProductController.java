package com.mengxuegu.springcloud.controller;

import com.mengxuegu.springcloud.entities.Product;
import com.mengxuegu.springcloud.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Product product) {
        return productService.add(product);
    }

    /** 添加熔断器注解, fallbackMethod 指定当get方法出现异常时，将要调用的处理方法。
        但是调用的处理方法，返回值和参数类型要一致 */
    @HystrixCommand(fallbackMethod = "getFallback")
    @RequestMapping(value = "/product/get/{id}", method = RequestMethod.GET)
    public Product get(@PathVariable("id") Long id) {
        Product product = productService.get(id);

        /** 如果product为空，则模拟一个异常 */
        if (product == null){
            throw  new RuntimeException("ID = " + id + " 无效！");
        }
        return product;
    }

    /** get方法失败时，调用此方法进行熔断处理 */
    public Product getFallback(@PathVariable("id") Long id){

        return new Product(id, "ID = " + id + " 无效！-----由@HystrixCommand 处理",
                "无法找到对应数据库！");

    }

    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public List<Product> list() {
        return productService.list();
    }

}
