package com.springboot.nebular.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.nebular.model.db.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}