package com.niq.interview.shelf.service.mapper;

import com.niq.interview.mapper.Mapper;
import com.niq.interview.product.model.Product;
import com.niq.interview.shelf.dto.DataApiInputDTO;
import com.niq.interview.shelf.model.Shelf;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class ShelfInputMapper implements Mapper<List<Shelf>, DataApiInputDTO> {

    @Override
    public DataApiInputDTO toDTO(List<Shelf> entity) {
        return null;
    }

    @Override
    public List<Shelf> fromDTO(DataApiInputDTO dto) {
        return dto.getShelf().stream().map(s -> new Shelf( new Product(s.getProductId()), dto.getShopperId(), s.getRelevancyScore())).collect(Collectors.toList());
    }
}
