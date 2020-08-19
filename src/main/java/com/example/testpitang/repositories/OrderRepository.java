package com.example.testpitang.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testpitang.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {

}
