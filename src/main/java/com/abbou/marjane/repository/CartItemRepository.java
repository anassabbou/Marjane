package com.abbou.marjane.repository;

import com.abbou.marjane.model.CartItem;
import com.abbou.marjane.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByProductId(Long productId);

    void deleteAllByCartId(Long cartId);
}
