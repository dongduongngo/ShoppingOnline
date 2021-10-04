package com.example.shoppingonline.service;

import com.example.shoppingonline.DTO.OrdersDto;
import com.example.shoppingonline.entity.Orders;

import java.util.List;

public interface IOrdersService {
//    List<Orders> getAllOrders();
    List<OrdersDto> getAllOrdersDtos();

    OrdersDto create(OrdersDto ordersDto);
    OrdersDto update(OrdersDto ordersDto);

    OrdersDto findOne(Long id);

    void delete(Long id);
}
