package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;

@Service("productserve")
public class ProductService {
              @Autowired
              ProductRepository productrepo;
              
              @Autowired
              CategoryRepository categoryrepo;
	public String saveProduct(Product product) {
		// TODO Auto-generated method stub
		
		Long cateid=product.getCategory().getId();
		Optional<Category>o=categoryrepo.findById(cateid);
		
		if(o.isPresent()) {
			product.setCategory(o.get());
			productrepo.save(product);
			return "product added successfully";
		}else {
			return "category not found";
		}
		
	}
	
	public Product getcategoryById(long id) {
		// TODO Auto-generated method stub
		  Optional <Product> o=productrepo.findById(id);
	        if(o.isPresent()) {
	        	Product p= o.get();
	        	return p;
	        }
		return null;
	}
	public String updateProductbyid(long id, Product product) {
		  Optional<Product>o=productrepo.findById(id);
		  if(o.isPresent()) {
			  Product p =o.get();
			  p.setName(product.getName());
			  p.setPrice(product.getPrice());
		     long cateid=product.getCategory().getId();
		     Optional<Category> o1 = categoryrepo.findById(cateid);
		        if (o1.isPresent()) {
		            p.setCategory(o1.get());
		        } else {
		            return "Category not found with the given ID: " + cateid;
		        }
			  productrepo.save(p);
			  return "product updated suceesfully...";
			  }else {
				  return "product not found with these id";
			  }
	}
	public String deleteproductById(long id) {
		    Optional<Product> o=productrepo.findById(id);
		    if(o.isPresent()) {
		       Product p =o.get();
		       productrepo.delete(p);
		        return "product deleted successfully..";
		    }else {
		    	return "product with this id not found...";
		    }
	
	}
	public Page<Product> getAllProducts(int page, int size) {
		// TODO Auto-generated method stub
		return productrepo.findAll(PageRequest.of(page,size));
	}

}
