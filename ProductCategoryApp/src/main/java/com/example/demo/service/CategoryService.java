package com.example.demo.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.CategoryRepository;

@Service("categoryserve")
public class CategoryService {
	@Autowired
     CategoryRepository categoryrepo;

	public Category addcategory(Category category) {
		// TODO Auto-generated method stub
		return categoryrepo.save(category);
	}

	public Page<Category> getCategories(int page,int size ) {
	    return categoryrepo.findAll(PageRequest.of(page, size));
	}

	public Category getcategoryById(long id) {
	        Optional <Category> o=categoryrepo.findById(id);
	        if(o.isPresent()) {
	        	Category c= o.get();
	        	return c;
	        }
		return null;
	}

	public String updatecategorybyid(long id,Category category) {
		// TODO Auto-generated method stub
		  Optional<Category>o=categoryrepo.findById(id);
		  if(o.isPresent()) {
			  Category c =o.get();
			  c.setName(category.getName());
			  categoryrepo.save(c);
			  return "category updated suceesfully...";
			  }else {
				  return "category not found with these id";
			  }
		
	}

	public String deleteCategoryById(long id) {
		 Optional<Category> o=categoryrepo.findById(id);
		    if(o.isPresent()) {
		       Category c =o.get();
		       categoryrepo.delete(c);
		        return "category deleted successfully..";
		    }else {
		    	return "category with this id not found...";
		    }
	}
	
	
}
