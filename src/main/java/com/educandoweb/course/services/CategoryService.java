package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository catRepository;
	
	public List<Category> findAll(){
		return catRepository.findAll();
	}
	
	public Category findById(long id) {
		Optional<Category> obj = catRepository.findById(id);
		return obj.get();
	}
}
