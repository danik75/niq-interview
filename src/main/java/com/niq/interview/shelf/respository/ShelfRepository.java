package com.niq.interview.shelf.respository;

import com.niq.interview.shelf.model.Shelf;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShelfRepository extends CrudRepository<Shelf, Long> {

    @Query(value = "SELECT s FROM Shelf s WHERE s.shopperId= ?1")
    List<Shelf> findByShopperId(String shopperId);
}
