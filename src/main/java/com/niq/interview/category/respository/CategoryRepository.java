package com.niq.interview.category.respository;

import com.niq.interview.category.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
