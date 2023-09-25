package com.example.ProductDemo.controller;

import com.example.ProductDemo.advice.NoSuchElementException;
import com.example.ProductDemo.model.ProductDto;
import com.example.ProductDemo.entity.Product;
import com.example.ProductDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody @Valid ProductDto dto){
        return new ResponseEntity<Product>(service.saveProduct(dto), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<List<Product>>(service.getAllProducts(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Integer id){
        return new ResponseEntity<String>(service.removeProductById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable Integer id,@RequestBody @Valid ProductDto dto) throws NoSuchElementException{
        return new ResponseEntity<>(service.updateProduct(id,dto), HttpStatus.OK);
    }


    @GetMapping("/customError")
    public ResponseEntity<String> triggerCustomError() {
        throw new NoSuchElementException("This is a custom exception.");
    }







}
