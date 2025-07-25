package com.ecommerce.shoppro.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.shoppro.domain.Product;

@Repository 
public interface ProductRepository extends JpaRepository<Product, Long> { 
List<Product> findByCategory(String category); 
List<Product> findByNameContainingIgnoreCase(String keyword); 
}


