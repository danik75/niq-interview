package com.niq.interview.category.service;

import com.niq.interview.category.model.Category;
import com.niq.interview.category.respository.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class CategoryService {

    private final CategoryRepository repository;


    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public void addCategory(Category c){
        this.repository.save(c);
    }

    public Iterable<Category> getAllCategories(){
        return repository.findAll();
    }
}
