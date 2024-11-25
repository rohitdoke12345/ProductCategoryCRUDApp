package com.example.demo.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Category;
@Repository("categoryrepo")
public interface CategoryRepository extends JpaRepository<Category, Long> {
	 Page<Category> findAll(Pageable pageable);
}


