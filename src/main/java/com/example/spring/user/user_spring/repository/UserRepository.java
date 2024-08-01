package com.example.spring.user.user_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.user.user_spring.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
