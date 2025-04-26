package com.abbou.marjane.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abbou.marjane.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
            boolean existsByEmail(String email);
    User findByEmail(String email);

}
        