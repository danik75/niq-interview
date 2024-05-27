package com.niq.interview.shelf.service;

import com.niq.interview.product.dto.ProductDTO;
import com.niq.interview.shelf.dto.DataApiInputDTO;
import com.niq.interview.shelf.model.Shelf;
import com.niq.interview.shelf.respository.ShelfRepository;
import com.niq.interview.shelf.service.mapper.ShelfInputMapper;
import com.niq.interview.shelf.service.mapper.ShelfResponseMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShelfService {
    private final ShelfRepository repository;
    private final ShelfInputMapper shelfInputMapper;
    private final ShelfResponseMapper shelfResponseMapper;

    public ShelfService(ShelfRepository repository, ShelfInputMapper mapper, ShelfResponseMapper shelfResponseMapper) {
        this.repository = repository;
        this.shelfInputMapper = mapper;
        this.shelfResponseMapper = shelfResponseMapper;
    }

    public void addShopperData(DataApiInputDTO dataApiInputDTO) {
        List<Shelf> shelfList = shelfInputMapper.fromDTO(dataApiInputDTO);
        repository.saveAll(shelfList);
    }

    public List<ProductDTO> getProductsByShopperId(String shopperId, String category, String brand, Integer limit) {
        limit = limit == null ? 10: Math.min(limit, 100);
        List<Shelf> byShopperId = repository.findByShopperId(shopperId, limit);
        if (category!=null){
            byShopperId = byShopperId.stream().filter(s-> s.getProduct().getCategory().equals(category)).collect(Collectors.toList());
        }
        if (brand!=null){
            byShopperId = byShopperId.stream().filter(s-> s.getProduct().getBrand().equals(brand)).collect(Collectors.toList());
        }
        return shelfResponseMapper.toDTO(byShopperId);
    }
}
