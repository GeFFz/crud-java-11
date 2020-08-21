package com.example.testpitang.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testpitang.entities.OrderItem;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
