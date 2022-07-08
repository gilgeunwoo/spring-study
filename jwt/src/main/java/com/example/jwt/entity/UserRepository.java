package com.example.jwt.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    public abstract Optional<User> findByUserEmail(String username);
}
