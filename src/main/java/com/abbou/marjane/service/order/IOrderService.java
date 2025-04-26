package com.abbou.marjane.service.order;

import java.util.List;

import com.abbou.marjane.dtos.OrderDto;
import com.abbou.marjane.model.Order;

public interface IOrderService {
        Order placeOrder(Long userId);
        List<OrderDto> getUserOrders(Long userId);
    
        OrderDto convertToDto(Order order);
    }
    