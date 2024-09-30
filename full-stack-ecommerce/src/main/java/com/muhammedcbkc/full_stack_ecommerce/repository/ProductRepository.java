package com.muhammedcbkc.full_stack_ecommerce.repository;

import com.muhammedcbkc.full_stack_ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
