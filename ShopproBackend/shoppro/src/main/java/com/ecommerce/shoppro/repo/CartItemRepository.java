package com.ecommerce.shoppro.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.shoppro.domain.CartItem;

@Repository 
public interface CartItemRepository extends JpaRepository<CartItem, Long> { 
List<CartItem> findByUserId(Long userId); 
Optional<CartItem> findByUserIdAndProductId(Long userId, Long productId); 
void deleteByUserId(Long userId); 
} 
