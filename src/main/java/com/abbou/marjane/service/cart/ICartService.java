package com.abbou.marjane.service.cart;

import java.math.BigDecimal;

import com.abbou.marjane.model.Cart;
import com.abbou.marjane.model.User;

public interface ICartService {
        Cart getCart(Long cartId);
    
        Cart getCartByUserId(Long userId);
    
        void clearCart(Long cartId);
    
        Cart initializeNewCartForUser(User user);
    
        BigDecimal getTotalPrice(Long cartId);
    }
    