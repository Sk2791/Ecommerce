package com.ecommerce.shoppro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shoppro.domain.Product;
import com.ecommerce.shoppro.repo.ProductRepository;

@RestController 
@RequestMapping("/api/products") 
@CrossOrigin(origins = "*") 
public class ProductController { 
@Autowired 
private ProductRepository productRepository; 
@GetMapping 
public List<Product> getAllProducts() { 
return productRepository.findAll(); 
} 
@GetMapping("/{id}") 
public ResponseEntity<Product> getProduct(@PathVariable Long id) { 
return productRepository.findById(id) 
.map(ResponseEntity::ok) 
.orElse(ResponseEntity.notFound().build()); 
} 
@PostMapping 
public ResponseEntity<Product> addProduct(@RequestBody Product product) { 
return ResponseEntity.ok(productRepository.save(product)); 
} 
@PutMapping("/{id}") 
public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody 
Product updated) { 
return productRepository.findById(id).map(product -> { 
product.setName(updated.getName()); 
product.setPrice(updated.getPrice()); 
product.setDescription(updated.getDescription()); 
product.setStock(updated.getStock()); 
return ResponseEntity.ok(productRepository.save(product)); 
}).orElse(ResponseEntity.notFound().build()); 
} 
@DeleteMapping("/{id}") 
public ResponseEntity<Void> deleteProduct(@PathVariable Long id) { 
productRepository.deleteById(id); 
return ResponseEntity.noContent().build(); 
} 
}
