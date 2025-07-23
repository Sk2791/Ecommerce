package com.ecommerce.shoppro.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.shoppro.domain.OrderItem;

@Repository 
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> { 
List<OrderItem> findByOrderId(Long orderId); 
} 
