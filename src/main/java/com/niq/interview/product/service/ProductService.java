package com.niq.interview.product.service;

import com.niq.interview.product.dto.ProductDTO;
import com.niq.interview.product.model.Product;
import com.niq.interview.product.respository.ProductRepository;
import com.niq.interview.product.service.mapper.ProductMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService {

    private final ProductRepository repository;

    private final ProductMapper mapper;

    public ProductService(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void addProduct(ProductDTO c){

        this.repository.save(mapper.fromDTO(c));
    }

    public List<ProductDTO> getAllProducts(){
        Iterable<Product> allProducts = repository.findAll();
        List<ProductDTO> result = new ArrayList<>();
        allProducts.forEach((p) -> result.add(mapper.toDTO(p)));
        return result;
    }
}
