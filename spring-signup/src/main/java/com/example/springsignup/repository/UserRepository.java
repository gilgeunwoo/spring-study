package com.example.springsignup.repository;


import com.example.springsignup.entity.Entity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface UserRepository extends CrudRepository<Entity, Long> {

    Optional<Entity> findByAccountId(String accountId);
}
