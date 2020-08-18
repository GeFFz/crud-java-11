package com.example.testpitang.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testpitang.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {

}
