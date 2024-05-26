package com.niq.interview.shelf.controller;

import com.niq.interview.shelf.model.Shelf;
import com.niq.interview.shelf.service.ShelfService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shelf")
public class ShelfController {

    private final ShelfService shelfService;

    public ShelfController(ShelfService categoryService) {
        this.shelfService = categoryService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Shelf shelf){
        this.shelfService.addShelf(shelf);
    }

    @GetMapping("/{shopperId}")
    public List<Shelf> findByShopperId(@PathVariable String shopperId, @RequestParam String brand){
        return  this.shelfService.findByShopperId(shopperId, brand);
    }

}
