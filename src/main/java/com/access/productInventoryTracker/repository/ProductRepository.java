package com.access.productInventoryTracker.repository;

import com.access.productInventoryTracker.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // You can add custom methods here if needed, for example: 
    // List<Product> findByCategory(String category);

	// BUG FIX: The original method was returning products that did not match the category due to incorrect filtering logic.
    @Query("SELECT p FROM Product p WHERE LOWER(p.category) = LOWER(:category) ORDER BY p.price DESC")
    List<Product> findProductsByCategory(@Param("category") String category);
}
