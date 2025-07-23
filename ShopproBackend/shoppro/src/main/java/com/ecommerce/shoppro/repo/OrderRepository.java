package com.ecommerce.shoppro.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.shoppro.domain.Order;

@Repository 
public interface OrderRepository extends JpaRepository<Order, Long> { 
List<Order> findByUserId(Long userId); 
} 
