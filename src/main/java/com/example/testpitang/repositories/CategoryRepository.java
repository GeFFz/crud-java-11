package com.example.testpitang.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testpitang.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}
