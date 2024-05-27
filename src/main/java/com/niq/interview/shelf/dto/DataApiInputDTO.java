package com.niq.interview.shelf.dto;

import java.util.List;

public class DataApiInputDTO {

    private String shopperId;

    private List<ShelfDTO> shelf;

    public DataApiInputDTO(String shopperId, List<ShelfDTO> shelf) {
        this.shopperId = shopperId;
        this.shelf = shelf;
    }

    public String getShopperId() {
        return shopperId;
    }

    public void setShopperId(String shopperId) {
        this.shopperId = shopperId;
    }

    public List<ShelfDTO> getShelf() {
        return shelf;
    }

    public void setShelf(List<ShelfDTO> shelf) {
        this.shelf = shelf;
    }
}
