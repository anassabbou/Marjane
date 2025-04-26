package com.abbou.marjane.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abbou.marjane.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
            List<Order> findByUserId(Long userId);
}
        