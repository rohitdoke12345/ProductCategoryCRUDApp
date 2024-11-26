package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
	CategoryService categoryserve;

	@PostMapping
	public String AddCategories(@RequestBody Category category) {
		// TODO: process POST request
		Category c = categoryserve.addcategory(category);
		return c != null ? "Category Added" : "category not added";
	}

	@GetMapping
	public Page<Category> getCategories(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		return categoryserve.getCategories(page, size);
	}

	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable long id) {
		return categoryserve.getcategoryById(id);
	}

	@PutMapping("/{id}")
	public String updateById(@PathVariable long id, @RequestBody Category category) {
		// TODO: process PUT request

		return categoryserve.updatecategorybyid(id, category);
	}

	@DeleteMapping("/{id}")
	public String deleteProductById(@PathVariable long id) {
		return categoryserve.deleteCategoryById(id);

	}

}
