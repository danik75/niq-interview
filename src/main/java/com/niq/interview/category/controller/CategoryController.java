package com.niq.interview.category.controller;

import com.niq.interview.category.model.Category;
import com.niq.interview.category.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Category category){
        this.categoryService.addCategory(category);
    }

    @GetMapping("")
    public Iterable<Category> findAll(){
        return  this.categoryService.getAllCategories();
    }

}
