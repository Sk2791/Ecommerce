package com.ecommerce.shoppro.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shoppro.domain.CartItem;
import com.ecommerce.shoppro.dto.CartItemDTO;
import com.ecommerce.shoppro.repo.CartItemRepository;

import jakarta.transaction.Transactional;

@RestController 
@RequestMapping("/api/cart") 
@CrossOrigin(origins = "*") 
public class CartController { 
@Autowired 
private CartItemRepository cartItemRepository; 
@PostMapping("/add") 
public ResponseEntity<CartItem> addToCart(@RequestBody CartItem cartItem) { 
Optional<CartItem> existing = cartItemRepository 
.findByUserIdAndProductId(cartItem.getUser().getId(), cartItem.getProduct().getId()); 
if (existing.isPresent()) { 
CartItem existingItem = existing.get(); 
existingItem.setQuantity(existingItem.getQuantity() + cartItem.getQuantity()); 
return ResponseEntity.ok(cartItemRepository.save(existingItem)); 
} 
return ResponseEntity.ok(cartItemRepository.save(cartItem)); 
} 
@GetMapping("/{userId}") 
public ResponseEntity<List<CartItemDTO>> getCart(@PathVariable Long userId){
	List<CartItem> items = cartItemRepository.findByUserId(userId);
	List<CartItemDTO> response = items.stream().map(item -> new CartItemDTO(
			item.getId(),
			item.getProduct().getName(),
			item.getQuantity(),
			item.getProduct().getPrice()
			)).collect(Collectors.toList());
	return ResponseEntity.ok(response);
} 
@DeleteMapping("/clear/{userId}") 
@Transactional
public ResponseEntity<Void> clearCart(@PathVariable Long userId) { 
cartItemRepository.deleteByUserId(userId); 
return ResponseEntity.noContent().build(); 
} 
} 
