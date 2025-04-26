package com.abbou.marjane.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abbou.marjane.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
            Cart findByUserId(Long userId);
}
        