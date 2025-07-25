package com.ecommerce.shoppro.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.shoppro.domain.Role;

@Repository 
public interface RoleRepository extends JpaRepository<Role, Long> { 
Optional<Role> findByName(String name); 
} 
