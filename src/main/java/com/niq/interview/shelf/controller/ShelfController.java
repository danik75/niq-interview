package com.niq.interview.shelf.controller;

import com.niq.interview.product.dto.ProductDTO;
import com.niq.interview.shelf.dto.DataApiInputDTO;
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
    public void create(@Valid @RequestBody DataApiInputDTO dataApiInputDTO){
        this.shelfService.addShopperData(dataApiInputDTO);
    }

    @GetMapping("/{shopperId}")
    public List<ProductDTO> getProductsByShopperId(@PathVariable String shopperId, @RequestParam(required = false) String category, @RequestParam(required = false) String brand, @RequestParam(required = false) Integer limit){
        return this.shelfService.getProductsByShopperId(shopperId, category,brand, limit);
    }


}
