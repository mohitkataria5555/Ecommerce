package com.VeggiesDelivery.controleer;

import com.VeggiesDelivery.entity.Product;
import com.VeggiesDelivery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController() {
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
       return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable long id){
        return productService.getProductById(id);
    }

    @PostMapping("/products/add")
    public ResponseEntity<String> addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return new ResponseEntity<String>("Product Added to DB.", HttpStatus.OK);
    }

    @PutMapping("/products/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable long id,@RequestBody Product product){
        productService.updateProduct(id, product);
        return new ResponseEntity<String>("Product Updated.", HttpStatus.OK);
    }

    @DeleteMapping("/products/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable long id){
        productService.deleteProduct(id);
        return new ResponseEntity<String>("Product Deleted.", HttpStatus.OK);
    }
}
