package com.example.testpitang.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testpitang.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
