package com.springjwt.services;

import com.springjwt.entities.Product;

import java.util.List;

public interface ProductService {

    public Product saveProduct(Product product);

    public List<Product> getAllProduct();

    public Product getProductById(Long id);

    public String deleteProduct(Long id);

    public Product editProduct(Product product,Long id);

}
