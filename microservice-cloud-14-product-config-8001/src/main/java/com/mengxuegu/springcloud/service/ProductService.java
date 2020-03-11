package com.mengxuegu.springcloud.service;

import com.mengxuegu.springcloud.entities.Product;
import java.util.List;

public interface ProductService {

    boolean add(Product product);

    Product get(Long id);

    List<Product> list();

}
