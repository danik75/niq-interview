package com.niq.interview.product.service.mapper;

import com.niq.interview.mapper.Mapper;
import com.niq.interview.product.dto.ProductDTO;
import com.niq.interview.product.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements Mapper<Product, ProductDTO> {

    @Override
    public ProductDTO toDTO(Product product) {
        return new ProductDTO(product.getId(), product.getCategory(), product.getBrand());
    }

    @Override
    public Product fromDTO(ProductDTO dto) {
        return new Product(dto.getId(), dto.getCategory(), dto.getBrand());
    }
}
