package cn.itcast.service;

import cn.itcast.domain.Product;

import java.util.List;

public interface ProductService {

     List<Product> findAll();

     void saveProduct(Product product);
}
