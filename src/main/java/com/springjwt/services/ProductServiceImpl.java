package com.springjwt.services;

import com.springjwt.entities.Product;
import com.springjwt.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Override
    public Product saveProduct(Product product) {

        return productRepo.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Product not found"));

    }

    @Override
    public String deleteProduct(Long id) {
        Product product = productRepo.findById(id).get();

        if (product != null) {
            productRepo.delete(product);
            return "Product Delete Sucessfully";
        }

        return "Something wrong on server";
    }

    @Override
    public Product editProduct(Product p, Long id) {

        Product oldProduct = productRepo.findById(id).get();

        oldProduct.setProductName(p.getProductName());
        oldProduct.setDescription(p.getDescription());
        oldProduct.setPrice(p.getPrice());
        oldProduct.setStatus(p.getStatus());

        return productRepo.save(oldProduct);
    }

}
