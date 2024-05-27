package com.niq.interview.shelf.service.mapper;

import com.niq.interview.mapper.Mapper;
import com.niq.interview.product.dto.ProductDTO;
import com.niq.interview.shelf.model.Shelf;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShelfResponseMapper implements Mapper<List<Shelf>, List<ProductDTO>> {

    @Override
    public List<ProductDTO> toDTO(List<Shelf> shelves) {
        return shelves.stream().map(s-> new ProductDTO(s.getProduct().getId(), s.getProduct().getCategory(), s.getProduct().getBrand())).collect(Collectors.toList());
    }

    @Override
    public List<Shelf> fromDTO(List<ProductDTO> dto) {
        return null;
    }
}
