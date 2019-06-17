package cn.itcast.dao;

import cn.itcast.domain.Product;

import java.util.List;

public interface ProductDao {

    List<Product> findAll();

    void saveProduct(Product product);

    Product findById(String id);
}
