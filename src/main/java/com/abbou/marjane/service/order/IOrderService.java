package com.abbou.marjane.service.order;

import com.abbou.marjane.dtos.OrderDto;
import com.abbou.marjane.model.Order;
import com.abbou.marjane.request.PaymentRequest;
import com.stripe.exception.StripeException;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);
    List<OrderDto> getUserOrders(Long userId);


    String createPaymentIntent(PaymentRequest request) throws StripeException;

    OrderDto convertToDto(Order order);
}
