package com.VeggiesDelivery.service;

import com.VeggiesDelivery.entity.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(long id);
    List<Product> getAllProducts();
    void addProduct(Product product);
    void updateProduct(long id ,Product product);
    void deleteProduct(long id);
}
