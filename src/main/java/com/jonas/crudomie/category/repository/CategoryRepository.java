package com.jonas.crudomie.category.repository;

import com.jonas.crudomie.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
