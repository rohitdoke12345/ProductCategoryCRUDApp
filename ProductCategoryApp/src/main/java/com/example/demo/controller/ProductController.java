package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;




@CrossOrigin("*")
@RestController
@RequestMapping("/api/products")
public class ProductController {
           @Autowired
           ProductService productserve;
           
           @PostMapping("/")
           public String saveProducts(@RequestBody Product product) {
               //TODO: process POST request
              
               return productserve.saveProduct(product);
           }
           @GetMapping("/")
           public Page<Product> getAllproducts(
               @RequestParam(defaultValue = "0") int page,
               @RequestParam(defaultValue = "10") int size
           ) {
               return productserve.getAllProducts(page, size);
           }

           
           @GetMapping("/{id}")
           public Product getProductById(@PathVariable long id ) {
               return productserve.getcategoryById(id);
           }
           
           @PutMapping("/{id}")
           public String updateproducts(@PathVariable long id, @RequestBody Product product) {
               //TODO: process PUT request
               
               return productserve.updateProductbyid(id,product);
           }
           
           @DeleteMapping("/{id}")
           public String deleteProductById(@PathVariable long id) {
			return productserve.deleteproductById(id);
        	   
           }
           
           
           
}
