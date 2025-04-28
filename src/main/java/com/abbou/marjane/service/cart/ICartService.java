package com.abbou.marjane.service.cart;

import com.abbou.marjane.dtos.CartDto;
import com.abbou.marjane.model.Cart;
import com.abbou.marjane.model.User;

import java.math.BigDecimal;

public interface ICartService {
    Cart getCart(Long cartId);

    Cart getCartByUserId(Long userId);

    void clearCart(Long cartId);

    Cart initializeNewCartForUser(User user);

    BigDecimal getTotalPrice(Long cartId);

    CartDto convertToDto(Cart cart);
}
