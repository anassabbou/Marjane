package com.abbou.marjane.service.cart;

import com.abbou.marjane.dtos.CartItemDto;
import com.abbou.marjane.model.CartItem;

public interface ICartItemService {
        void addItemToCart(Long cartId, Long productId, int quantity);
        void removeItemFromCart(Long cartId, Long productId);
        void updateItemQuantity(Long cartId, Long productId, int quantity);
        CartItem getCartItem(Long cartId, Long productId);
    CartItemDto convertToDto(CartItem cartItem);


}
    