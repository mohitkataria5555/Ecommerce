package com.VeggiesDelivery.service;

import com.VeggiesDelivery.entity.Product;
import com.VeggiesDelivery.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepo;

    @Override
    public Product getProductById(long id) {
        return productRepo.findById(id).get();
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepo.findAll();
    }

    @Override
    public void addProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public void updateProduct(long id, Product product) {
        productRepo.save(product);
    }

    @Override
    public void deleteProduct(long id) {
        productRepo.deleteById(id);
    }
}
