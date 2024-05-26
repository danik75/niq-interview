package com.niq.interview.shelf.service;

import com.niq.interview.shelf.model.Shelf;
import com.niq.interview.shelf.respository.ShelfRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShelfService {

    private final ShelfRepository repository;


    public ShelfService(ShelfRepository repository) {
        this.repository = repository;
    }

    public void addShelf(Shelf s){
        this.repository.save(s);
    }

    public List<Shelf> findByShopperId(String shopperId) {
        return this.repository.findByShopperId(shopperId);
    }
}
