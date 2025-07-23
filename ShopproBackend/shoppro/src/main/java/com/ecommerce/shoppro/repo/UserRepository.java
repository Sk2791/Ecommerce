package com.ecommerce.shoppro.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.shoppro.domain.User;

@Repository 
public interface UserRepository extends JpaRepository<User, Long> { 
    Optional<User> findByEmail(String email); 
}
