package com.niq.interview.product.controller;

import com.niq.interview.product.dto.ProductDTO;
import com.niq.interview.product.model.Product;
import com.niq.interview.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody ProductDTO product){
        this.productService.addProduct(product);
    }

    @GetMapping("")
    public List<ProductDTO> findAll(){
        return this.productService.getAllProducts();
    }

}
