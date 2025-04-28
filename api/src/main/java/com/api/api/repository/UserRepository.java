package com.api.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.api.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByEmail(String email);

    Optional<User> findByNameOrEmail(String name, String email);

    Optional<User> findByName(String name);

    boolean existsByName(String name);

    boolean existsByEmail(String email);

}
