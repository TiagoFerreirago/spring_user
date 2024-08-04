package com.example.spring.user.userspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.user.userspring.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
