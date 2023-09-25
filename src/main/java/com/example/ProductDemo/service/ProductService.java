package com.example.ProductDemo.service;

import com.example.ProductDemo.advice.NoSuchElementException;
import com.example.ProductDemo.model.ProductDto;
import com.example.ProductDemo.entity.Product;
import com.example.ProductDemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public Product saveProduct(ProductDto dto) {
        Product product=new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setBrand(dto.getBrand());
        return repository.save(product);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public String removeProductById(Integer id) {
        repository.deleteById(id);
        return "product deleted by product id " + id;
    }

    public Product updateProduct(Integer id, ProductDto dto) throws NoSuchElementException {
        Optional<Product> optionalProduct= repository.findById(id);
        if(optionalProduct==null){
            throw new NoSuchElementException("no element found with this id"+id);
        }
        Product product=optionalProduct.get();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setBrand(dto.getBrand());
        repository.save(product);
        return product;
    }
}
